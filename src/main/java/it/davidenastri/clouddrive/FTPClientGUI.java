package it.davidenastri.clouddrive;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FTPClientGUI extends JFrame {
    private JTable fileTable;
    private FTPClient ftpClient;

    // Các thành phần giao diện để nhập thông tin đăng nhập
    private JTextField txtFTPAddress;
    private JTextField txtPort;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnDownload;
    private JButton btnPreview;

    // Thanh tiến trình tải file
    private JProgressBar progressBar;

    public FTPClientGUI() {
        setTitle("FTP Client");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Khởi tạo FTPClient
        ftpClient = new FTPClient();

        // Panel đăng nhập
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(5, 2));

        loginPanel.add(new JLabel("FTP Server Address:"));
        txtFTPAddress = new JTextField("localhost");
        loginPanel.add(txtFTPAddress);

        loginPanel.add(new JLabel("Port:"));
        txtPort = new JTextField("2121");
        loginPanel.add(txtPort);

        loginPanel.add(new JLabel("Username:"));
        txtUsername = new JTextField("admin");
        loginPanel.add(txtUsername);

        loginPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField("admin123");
        loginPanel.add(txtPassword);

        btnLogin = new JButton("Login");
        loginPanel.add(new JLabel()); // Chỗ trống
        loginPanel.add(btnLogin);

        add(loginPanel, BorderLayout.NORTH);

        // Kết nối và đăng nhập vào FTP server khi nhấn "Login"
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ftpAddress = txtFTPAddress.getText().trim();
                int port = Integer.parseInt(txtPort.getText().trim());
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();

                try {
                    ftpClient.connect(ftpAddress, port);  // Kết nối đến FTP server
                    boolean loginSuccess = ftpClient.login(username, password); // Đăng nhập vào FTP server
                    if (loginSuccess) {
                        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);  // Thiết lập kiểu file
                        fetchFileList();  // Lấy danh sách file sau khi đăng nhập thành công
                    } else {
                        JOptionPane.showMessageDialog(FTPClientGUI.this, "Đăng nhập thất bại. Kiểm tra lại thông tin.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FTPClientGUI.this, "Lỗi kết nối FTP: " + ex.getMessage());
                }
            }
        });

        // Tạo JTable để hiển thị danh sách file
        String[] columnNames = {"File Name", "Size"};
        fileTable = new JTable(new Object[0][0], columnNames);  // Khởi tạo JTable rỗng
        JScrollPane scrollPane = new JScrollPane(fileTable);

        // Thêm bảng vào giao diện
        add(scrollPane, BorderLayout.CENTER);

        // Panel hành động để tải và xem trước file
        JPanel actionPanel = new JPanel();
        btnDownload = new JButton("Download");
        btnPreview = new JButton("Preview");

        actionPanel.add(btnDownload);
        actionPanel.add(btnPreview);

        add(actionPanel, BorderLayout.SOUTH);

        // Thanh tiến trình
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        actionPanel.add(progressBar);

        // Tải file
        btnDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String fileName = (String) fileTable.getValueAt(selectedRow, 0);
                    downloadFile(fileName);
                } else {
                    JOptionPane.showMessageDialog(FTPClientGUI.this, "Vui lòng chọn file để tải.");
                }
            }
        });

        // Xem trước file (chỉ hỗ trợ văn bản)
        btnPreview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String fileName = (String) fileTable.getValueAt(selectedRow, 0);
                    previewFile(fileName);
                } else {
                    JOptionPane.showMessageDialog(FTPClientGUI.this, "Vui lòng chọn file để xem trước.");
                }
            }
        });
    }

    // Lấy danh sách file từ server FTP và hiển thị trong JTable
    private void fetchFileList() {
        try {
            String[] fileNames = ftpClient.listNames();  // Lấy danh sách tên file trên server
            Object[][] data = new Object[fileNames.length][2];
            for (int i = 0; i < fileNames.length; i++) {
                // Lấy kích thước file (ví dụ chỉ lấy kích thước file)
                data[i][0] = fileNames[i];
                data[i][1] = ftpClient.mlistFile(fileNames[i]).getSize(); // Lấy kích thước file
            }

            // Cập nhật JTable với dữ liệu file
            fileTable.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"File Name", "Size"}));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách file: " + e.getMessage());
        }
    }

    // Tải file từ FTP server về
    private void downloadFile(String fileName) {
        // Chọn vị trí lưu file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");
        fileChooser.setSelectedFile(new File(fileName)); // Đặt tên file mặc định là tên file cần tải
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File localFile = fileChooser.getSelectedFile();

            // Sử dụng SwingWorker để tải file và cập nhật thanh tiến trình
            new SwingWorker<Void, Integer>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try (FileOutputStream fos = new FileOutputStream(localFile);
                         InputStream inputStream = ftpClient.retrieveFileStream(fileName)) {

                        long fileSize = ftpClient.mlistFile(fileName).getSize();
                        byte[] bytesArray = new byte[4096];
                        int bytesRead;
                        long totalBytesRead = 0;

                        // Tải file từng phần và cập nhật tiến trình
                        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                            fos.write(bytesArray, 0, bytesRead);
                            totalBytesRead += bytesRead;

                            // Cập nhật tiến trình
                            int progress = (int) ((totalBytesRead * 100) / fileSize);
                            publish(progress);  // Gửi tiến trình tới process
                        }

                        boolean success = ftpClient.completePendingCommand();
                        if (success) {
                            JOptionPane.showMessageDialog(FTPClientGUI.this, "File đã được tải về: " + localFile.getAbsolutePath());
                        } else {
                            JOptionPane.showMessageDialog(FTPClientGUI.this, "Lỗi khi tải file.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(FTPClientGUI.this, "Lỗi khi tải file: " + e.getMessage());
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<Integer> chunks) {
                    // Cập nhật tiến trình từ các chunk
                    for (Integer progress : chunks) {
                        progressBar.setValue(progress);
                    }
                }

                @Override
                protected void done() {
                    // Đặt tiến trình về 100% khi hoàn thành
                    progressBar.setValue(100);
                }
            }.execute();
        }
    }

    // Xem trước file (chỉ hỗ trợ các file văn bản)
    private void previewFile(String fileName) {
        try {
            InputStream inputStream = ftpClient.retrieveFileStream(fileName);
            StringBuilder fileContent = new StringBuilder();
            int ch;
            while ((ch = inputStream.read()) != -1) {
                fileContent.append((char) ch);
            }
            inputStream.close();

            JTextArea textArea = new JTextArea(fileContent.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Preview - " + fileName, JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xem trước file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FTPClientGUI().setVisible(true);
            }
        });
    }
}
