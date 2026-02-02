package it.davidenastri.clouddrive;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FTPServerGUI extends JFrame {
    private JTextArea txtStatus;
    private JButton btnStartServer;
    private JButton btnStopServer;
    private JButton btnUpload;
    private JButton btnDownload;
    private JButton btnDelete;  // Nút xóa file
    private JButton btnCreateFolder;  // Nút tạo thư mục
    private JProgressBar progressBar;
    private FtpServerManager ftpServerManager;
    private JTable fileTable;  // Bảng hiển thị danh sách file

    public FTPServerGUI() {
        setTitle("FTP Server - Main Interface");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Khởi tạo FTPServerManager để quản lý server
        ftpServerManager = new FtpServerManager();

        // Khu vực điều khiển server
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        btnStartServer = new JButton("Start FTP Server");
        btnStopServer = new JButton("Stop FTP Server");

        controlPanel.add(btnStartServer);
        controlPanel.add(btnStopServer);

        // Khu vực upload và download file
        JPanel filePanel = new JPanel();
        filePanel.setLayout(new FlowLayout());

        btnUpload = new JButton("Upload File");
        btnDownload = new JButton("Download File");
        btnDelete = new JButton("Delete File");  // Nút xóa file
        btnCreateFolder = new JButton("Create Folder");  // Nút tạo thư mục

        filePanel.add(btnUpload);
        filePanel.add(btnDownload);
        filePanel.add(btnDelete);
        filePanel.add(btnCreateFolder);  // Thêm nút tạo thư mục

        // Thêm thanh tiến trình vào giao diện
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        filePanel.add(progressBar);

        // Khu vực hiển thị trạng thái
        txtStatus = new JTextArea(10, 40);
        txtStatus.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtStatus);

        // Tạo bảng để hiển thị danh sách file
        fileTable = new JTable();
        JScrollPane fileScrollPane = new JScrollPane(fileTable);

        // Thêm các phần vào giao diện
        add(controlPanel, BorderLayout.NORTH);
        add(filePanel, BorderLayout.CENTER);
        add(fileScrollPane, BorderLayout.EAST);  // Đưa bảng vào phía bên phải
        add(scrollPane, BorderLayout.SOUTH);

        // Sự kiện bắt đầu server
        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    txtStatus.append("Starting FTP Server...\n");
                    ftpServerManager.startServer();
                    txtStatus.append("FTP Server started on port 2121.\n");
                    refreshFileList();  // Làm mới danh sách file ngay khi giao diện được hiển thị
                } catch (Exception ex) {
                    txtStatus.append("Error starting FTP server: " + ex.getMessage() + "\n");
                    ex.printStackTrace();
                }
            }
        });

        // Sự kiện dừng server
        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtStatus.append("Stopping FTP Server...\n");
                ftpServerManager.stopServer();
                txtStatus.append("FTP Server stopped.\n");
            }
        });

        // Sự kiện upload file
        btnUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    new Thread(() -> uploadFile(selectedFile)).start();  // Đưa vào thread riêng
                }
                refreshFileList();  // Làm mới danh sách file ngay khi giao diện được hiển thị
            }
        });

        // Sự kiện download file
        btnDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    FTPClientHandler.downloadFile("localhost", 2121, "admin", "admin123", "remote/path/to/file", selectedFile.getAbsolutePath());
                    txtStatus.append("File downloaded successfully: " + selectedFile.getName() + "\n");
                }
            }
        });

        // Sự kiện xóa file
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy tên file từ bảng
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) fileTable.getValueAt(selectedRow, 0);
                    deleteFile(fileName);
                } else {
                    JOptionPane.showMessageDialog(FTPServerGUI.this, "Please select a file to delete.");
                }
            }
        });

        // Sự kiện tạo thư mục mới
        btnCreateFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String folderName = JOptionPane.showInputDialog(FTPServerGUI.this, "Enter folder name:");
                if (folderName != null && !folderName.trim().isEmpty()) {
                    createFolder(folderName);
                } else {
                    JOptionPane.showMessageDialog(FTPServerGUI.this, "Folder name cannot be empty.");
                }
            }
        });
    }

    // Hàm tải lên file
    private void uploadFile(File file) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("localhost", 2121);
            boolean login = ftpClient.login("admin", "admin123");
            if (!login) {
                JOptionPane.showMessageDialog(this, "FTP login failed.");
                return;
            }

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setSoTimeout(30000);  // Timeout cho kết nối

            long fileSize = file.length();
            long bytesUploaded = 0;
            try (InputStream inputStream = new FileInputStream(file)) {
                boolean success = ftpClient.storeFile(file.getName(), inputStream);
                while (bytesUploaded < fileSize) {
                    bytesUploaded += 4096;  // Giả sử mỗi lần tải lên 4KB
                    int progress = (int) ((bytesUploaded * 100) / fileSize);
                    progressBar.setValue(progress);  // Cập nhật thanh tiến trình

                    if (progress >= 100) {
                        progressBar.setValue(100);
                        break;
                    }
                }

                if (success) {
                    txtStatus.append("File uploaded successfully: " + file.getName() + "\n");
                    refreshFileList();  // Làm mới danh sách file ngay khi giao diện được hiển thị

                } else {
                    txtStatus.append("Error uploading file: " + file.getName() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "FTP connection error: " + e.getMessage());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Hàm tạo thư mục trên FTP server
    private void createFolder(String folderName) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("localhost", 2121);
            boolean login = ftpClient.login("admin", "admin123");
            if (!login) {
                JOptionPane.showMessageDialog(this, "FTP login failed.");
                return;
            }

            boolean success = ftpClient.makeDirectory(folderName);
            if (success) {
                txtStatus.append("Folder created successfully: " + folderName + "\n");
                refreshFileList();  // Làm mới danh sách file
            } else {
                txtStatus.append("Error creating folder: " + folderName + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "FTP connection error: " + e.getMessage());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Hàm xóa file
    private void deleteFile(String fileName) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("localhost", 2121); boolean login = ftpClient.login("admin", "admin123"); if (!login) { JOptionPane.showMessageDialog(this, "FTP login failed."); return; }
            boolean success = ftpClient.deleteFile(fileName);
            if (success) {
                txtStatus.append("File deleted successfully: " + fileName + "\n");
                refreshFileList();  // Cập nhật lại danh sách file
            } else {
                txtStatus.append("Error deleting file: " + fileName + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "FTP connection error: " + e.getMessage());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Hàm làm mới danh sách file trong bảng
    private void refreshFileList() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("localhost", 2121);
            boolean login = ftpClient.login("admin", "admin123");
            if (!login) {
                JOptionPane.showMessageDialog(this, "FTP login failed.");
                return;
            }

            // Lấy danh sách tên các file trên server FTP
            String[] fileNames = ftpClient.listNames();
            if (fileNames == null || fileNames.length == 0) {
                JOptionPane.showMessageDialog(this, "No files found on the server.");
                return;
            }

            // Tạo dữ liệu cho JTable
            Object[][] data = new Object[fileNames.length][1];
            for (int i = 0; i < fileNames.length; i++) {
                data[i][0] = fileNames[i];
            }

            // Đặt lại model cho JTable với dữ liệu mới
            String[] columnNames = {"File Name"};
            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
            fileTable.setModel(tableModel);

            txtStatus.append("File list refreshed.\n");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "FTP connection error: " + e.getMessage());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FTPServerGUI gui = new FTPServerGUI();
                gui.setVisible(true); // Mở giao diện chính sau khi đăng nhập
            }
        });
    }
}

