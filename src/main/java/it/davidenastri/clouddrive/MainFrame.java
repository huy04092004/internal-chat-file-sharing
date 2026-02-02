//package it.davidenastri.clouddrive;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class MainFrame extends JFrame {
//
//    private JButton startFTPButton;
//    private JButton stopFTPButton;
//    private JButton uploadButton;
//    private JButton downloadButton;
//    private JTextArea logArea;
//
//    private FtpServerManager ftpServerManager;
//
//    public MainFrame() {
//        setTitle("FTP File Sharing");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Giao diện chính
//        setLayout(new BorderLayout());
//
//        // Khu vực log
//        logArea = new JTextArea();
//        logArea.setEditable(false);
//        add(new JScrollPane(logArea), BorderLayout.CENTER);
//
//        // Nút điều khiển FTP
//        JPanel controlPanel = new JPanel();
//        startFTPButton = new JButton("Khởi động FTP Server");
//        stopFTPButton = new JButton("Dừng FTP Server");
//        stopFTPButton.setEnabled(false); // Chỉ bật khi server đang chạy
//        controlPanel.add(startFTPButton);
//        controlPanel.add(stopFTPButton);
//
//        // Thêm các nút upload/download
//        uploadButton = new JButton("Tải lên File");
//        downloadButton = new JButton("Tải xuống File");
//        controlPanel.add(uploadButton);
//        controlPanel.add(downloadButton);
//
//        add(controlPanel, BorderLayout.SOUTH);
//
//        // Thêm sự kiện
//        startFTPButton.addActionListener(this::onStartFTPServer);
//        stopFTPButton.addActionListener(this::onStopFTPServer);
//        uploadButton.addActionListener(this::onUploadFile);
//        downloadButton.addActionListener(this::onDownloadFile);
//
//        // Khởi tạo FTP server manager
//        ftpServerManager = new FtpServerManager();
//    }
//
//    private void onStartFTPServer(ActionEvent e) {
//        try {
//            ftpServerManager.startServer();
//            logArea.append("FTP Server started on port 2121\n");
//            startFTPButton.setEnabled(false);
//            stopFTPButton.setEnabled(true);
//        } catch (Exception ex) {
//            logArea.append("Failed to start FTP Server: " + ex.getMessage() + "\n");
//        }
//    }
//
//    private void onStopFTPServer(ActionEvent e) {
//        ftpServerManager.stopServer();
//        logArea.append("FTP Server stopped\n");
//        startFTPButton.setEnabled(true);
//        stopFTPButton.setEnabled(false);
//    }
//
//    private void onUploadFile(ActionEvent e) {
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Uploading file: " + filePath + "\n");
//            FTPClientHandler.uploadFile("localhost", 2121, "admin", "admin123", filePath);
//        }
//    }
//
//    private void onDownloadFile(ActionEvent e) {
//        String remoteFilePath = JOptionPane.showInputDialog(this, "Nhập đường dẫn file cần tải:");
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int result = fileChooser.showSaveDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String localPath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Downloading file to: " + localPath + "\n");
//            FTPClientHandler.downloadFile("localhost", 2121, "admin", "admin123", remoteFilePath, localPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.setVisible(true);
//        });
//    }
//}
//package it.davidenastri.clouddrive;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class MainFrame extends JFrame {
//
//    private JButton startFTPButton;
//    private JButton stopFTPButton;
//    private JButton uploadButton;
//    private JButton downloadButton;
//    private JTextArea logArea;
//
//    private FtpServerManager ftpServerManager;
//
//    public MainFrame() {
//        setTitle("FTP File Sharing");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Giao diện chính
//        setLayout(new BorderLayout());
//
//        // Khu vực log
//        logArea = new JTextArea();
//        logArea.setEditable(false);
//        add(new JScrollPane(logArea), BorderLayout.CENTER);
//
//        // Nút điều khiển FTP
//        JPanel controlPanel = new JPanel();
//        startFTPButton = new JButton("Khởi động FTP Server");
//        stopFTPButton = new JButton("Dừng FTP Server");
//        stopFTPButton.setEnabled(false); // Chỉ bật khi server đang chạy
//        controlPanel.add(startFTPButton);
//        controlPanel.add(stopFTPButton);
//
//        // Thêm các nút upload/download
//        uploadButton = new JButton("Tải lên File");
//        downloadButton = new JButton("Tải xuống File");
//        controlPanel.add(uploadButton);
//        controlPanel.add(downloadButton);
//
//        add(controlPanel, BorderLayout.SOUTH);
//
//        // Thêm sự kiện
//        startFTPButton.addActionListener(this::onStartFTPServer);
//        stopFTPButton.addActionListener(this::onStopFTPServer);
//        uploadButton.addActionListener(this::onUploadFile);
//        downloadButton.addActionListener(this::onDownloadFile);
//
//        // Khởi tạo FTP server manager
//        ftpServerManager = new FtpServerManager();
//    }
//
//    private void onStartFTPServer(ActionEvent e) {
//        try {
//            ftpServerManager.startServer();
//            logArea.append("FTP Server started on port 2121\n");
//            startFTPButton.setEnabled(false);
//            stopFTPButton.setEnabled(true);
//        } catch (Exception ex) {
//            logArea.append("Failed to start FTP Server: " + ex.getMessage() + "\n");
//        }
//    }
//
//    private void onStopFTPServer(ActionEvent e) {
//        ftpServerManager.stopServer();
//        logArea.append("FTP Server stopped\n");
//        startFTPButton.setEnabled(true);
//        stopFTPButton.setEnabled(false);
//    }
//
//    private void onUploadFile(ActionEvent e) {
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Uploading file: " + filePath + "\n");
//            FTPClientHandler.uploadFile("localhost", 2121, "admin", "admin123", filePath);
//        }
//    }
//
//    private void onDownloadFile(ActionEvent e) {
//        String remoteFilePath = JOptionPane.showInputDialog(this, "Nhập đường dẫn file cần tải:");
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int result = fileChooser.showSaveDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String localPath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Downloading file to: " + localPath + "\n");
//            FTPClientHandler.downloadFile("localhost", 2121, "admin", "admin123", remoteFilePath, localPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.setVisible(true);
//        });
//    }
//}
//package it.davidenastri.clouddrive;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class MainFrame extends JFrame {
//
//    private JButton startFTPButton;
//    private JButton stopFTPButton;
//    private JButton uploadButton;
//    private JButton downloadButton;
//    private JTextArea logArea;
//
//    private FtpServerManager ftpServerManager;
//
//    public MainFrame() {
//        setTitle("FTP File Sharing");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Giao diện chính
//        setLayout(new BorderLayout());
//
//        // Khu vực log
//        logArea = new JTextArea();
//        logArea.setEditable(false);
//        add(new JScrollPane(logArea), BorderLayout.CENTER);
//
//        // Nút điều khiển FTP
//        JPanel controlPanel = new JPanel();
//        startFTPButton = new JButton("Khởi động FTP Server");
//        stopFTPButton = new JButton("Dừng FTP Server");
//        stopFTPButton.setEnabled(false); // Chỉ bật khi server đang chạy
//        controlPanel.add(startFTPButton);
//        controlPanel.add(stopFTPButton);
//
//        // Thêm các nút upload/download
//        uploadButton = new JButton("Tải lên File");
//        downloadButton = new JButton("Tải xuống File");
//        controlPanel.add(uploadButton);
//        controlPanel.add(downloadButton);
//
//        add(controlPanel, BorderLayout.SOUTH);
//
//        // Thêm sự kiện
//        startFTPButton.addActionListener(this::onStartFTPServer);
//        stopFTPButton.addActionListener(this::onStopFTPServer);
//        uploadButton.addActionListener(this::onUploadFile);
//        downloadButton.addActionListener(this::onDownloadFile);
//
//        // Khởi tạo FTP server manager
//        ftpServerManager = new FtpServerManager();
//    }
//
//    private void onStartFTPServer(ActionEvent e) {
//        try {
//            ftpServerManager.startServer();
//            logArea.append("FTP Server started on port 2121\n");
//            startFTPButton.setEnabled(false);
//            stopFTPButton.setEnabled(true);
//        } catch (Exception ex) {
//            logArea.append("Failed to start FTP Server: " + ex.getMessage() + "\n");
//        }
//    }
//
//    private void onStopFTPServer(ActionEvent e) {
//        ftpServerManager.stopServer();
//        logArea.append("FTP Server stopped\n");
//        startFTPButton.setEnabled(true);
//        stopFTPButton.setEnabled(false);
//    }
//
//    private void onUploadFile(ActionEvent e) {
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Uploading file: " + filePath + "\n");
//            FTPClientHandler.uploadFile("localhost", 2121, "admin", "admin123", filePath);
//        }
//    }
//
//    private void onDownloadFile(ActionEvent e) {
//        String remoteFilePath = JOptionPane.showInputDialog(this, "Nhập đường dẫn file cần tải:");
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int result = fileChooser.showSaveDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String localPath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Downloading file to: " + localPath + "\n");
//            FTPClientHandler.downloadFile("localhost", 2121, "admin", "admin123", remoteFilePath, localPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.setVisible(true);
//        });
//    }
//}
//package it.davidenastri.clouddrive;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class MainFrame extends JFrame {
//
//    private JButton startFTPButton;
//    private JButton stopFTPButton;
//    private JButton uploadButton;
//    private JButton downloadButton;
//    private JTextArea logArea;
//
//    private FtpServerManager ftpServerManager;
//
//    public MainFrame() {
//        setTitle("FTP File Sharing");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Giao diện chính
//        setLayout(new BorderLayout());
//
//        // Khu vực log
//        logArea = new JTextArea();
//        logArea.setEditable(false);
//        add(new JScrollPane(logArea), BorderLayout.CENTER);
//
//        // Nút điều khiển FTP
//        JPanel controlPanel = new JPanel();
//        startFTPButton = new JButton("Khởi động FTP Server");
//        stopFTPButton = new JButton("Dừng FTP Server");
//        stopFTPButton.setEnabled(false); // Chỉ bật khi server đang chạy
//        controlPanel.add(startFTPButton);
//        controlPanel.add(stopFTPButton);
//
//        // Thêm các nút upload/download
//        uploadButton = new JButton("Tải lên File");
//        downloadButton = new JButton("Tải xuống File");
//        controlPanel.add(uploadButton);
//        controlPanel.add(downloadButton);
//
//        add(controlPanel, BorderLayout.SOUTH);
//
//        // Thêm sự kiện
//        startFTPButton.addActionListener(this::onStartFTPServer);
//        stopFTPButton.addActionListener(this::onStopFTPServer);
//        uploadButton.addActionListener(this::onUploadFile);
//        downloadButton.addActionListener(this::onDownloadFile);
//
//        // Khởi tạo FTP server manager
//        ftpServerManager = new FtpServerManager();
//    }
//
//    private void onStartFTPServer(ActionEvent e) {
//        try {
//            ftpServerManager.startServer();
//            logArea.append("FTP Server started on port 2121\n");
//            startFTPButton.setEnabled(false);
//            stopFTPButton.setEnabled(true);
//        } catch (Exception ex) {
//            logArea.append("Failed to start FTP Server: " + ex.getMessage() + "\n");
//        }
//    }
//
//    private void onStopFTPServer(ActionEvent e) {
//        ftpServerManager.stopServer();
//        logArea.append("FTP Server stopped\n");
//        startFTPButton.setEnabled(true);
//        stopFTPButton.setEnabled(false);
//    }
//
//    private void onUploadFile(ActionEvent e) {
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Uploading file: " + filePath + "\n");
//            FTPClientHandler.uploadFile("localhost", 2121, "admin", "admin123", filePath);
//        }
//    }
//
//    private void onDownloadFile(ActionEvent e) {
//        String remoteFilePath = JOptionPane.showInputDialog(this, "Nhập đường dẫn file cần tải:");
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int result = fileChooser.showSaveDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String localPath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Downloading file to: " + localPath + "\n");
//            FTPClientHandler.downloadFile("localhost", 2121, "admin", "admin123", remoteFilePath, localPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.setVisible(true);
//        });
//    }
//}
//package it.davidenastri.clouddrive;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public class MainFrame extends JFrame {
//
//    private JButton startFTPButton;
//    private JButton stopFTPButton;
//    private JButton uploadButton;
//    private JButton downloadButton;
//    private JTextArea logArea;
//
//    private FtpServerManager ftpServerManager;
//
//    public MainFrame() {
//        setTitle("FTP File Sharing");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Giao diện chính
//        setLayout(new BorderLayout());
//
//        // Khu vực log
//        logArea = new JTextArea();
//        logArea.setEditable(false);
//        add(new JScrollPane(logArea), BorderLayout.CENTER);
//
//        // Nút điều khiển FTP
//        JPanel controlPanel = new JPanel();
//        startFTPButton = new JButton("Khởi động FTP Server");
//        stopFTPButton = new JButton("Dừng FTP Server");
//        stopFTPButton.setEnabled(false); // Chỉ bật khi server đang chạy
//        controlPanel.add(startFTPButton);
//        controlPanel.add(stopFTPButton);
//
//        // Thêm các nút upload/download
//        uploadButton = new JButton("Tải lên File");
//        downloadButton = new JButton("Tải xuống File");
//        controlPanel.add(uploadButton);
//        controlPanel.add(downloadButton);
//
//        add(controlPanel, BorderLayout.SOUTH);
//
//        // Thêm sự kiện
//        startFTPButton.addActionListener(this::onStartFTPServer);
//        stopFTPButton.addActionListener(this::onStopFTPServer);
//        uploadButton.addActionListener(this::onUploadFile);
//        downloadButton.addActionListener(this::onDownloadFile);
//
//        // Khởi tạo FTP server manager
//        ftpServerManager = new FtpServerManager();
//    }
//
//    private void onStartFTPServer(ActionEvent e) {
//        try {
//            ftpServerManager.startServer();
//            logArea.append("FTP Server started on port 2121\n");
//            startFTPButton.setEnabled(false);
//            stopFTPButton.setEnabled(true);
//        } catch (Exception ex) {
//            logArea.append("Failed to start FTP Server: " + ex.getMessage() + "\n");
//        }
//    }
//
//    private void onStopFTPServer(ActionEvent e) {
//        ftpServerManager.stopServer();
//        logArea.append("FTP Server stopped\n");
//        startFTPButton.setEnabled(true);
//        stopFTPButton.setEnabled(false);
//    }
//
//    private void onUploadFile(ActionEvent e) {
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Uploading file: " + filePath + "\n");
//            FTPClientHandler.uploadFile("localhost", 2121, "admin", "admin123", filePath);
//        }
//    }
//
//    private void onDownloadFile(ActionEvent e) {
//        String remoteFilePath = JOptionPane.showInputDialog(this, "Nhập đường dẫn file cần tải:");
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int result = fileChooser.showSaveDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            String localPath = fileChooser.getSelectedFile().getAbsolutePath();
//            logArea.append("Downloading file to: " + localPath + "\n");
//            FTPClientHandler.downloadFile("localhost", 2121, "admin", "admin123", remoteFilePath, localPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.setVisible(true);
//        });
//    }
//}

