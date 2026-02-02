//package it.davidenastri.clouddrive;
//
//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//
//public class FTPClientGUI extends JFrame {
//    private JTable fileTable;
//    private FTPClient ftpClient;
//
//    // Các thành phần giao diện để nhập thông tin đăng nhập
//    private JTextField txtFTPAddress;
//    private JTextField txtPort;
//    private JTextField txtUsername;
//    private JPasswordField txtPassword;
//    private JButton btnLogin;
//
//    public FTPClientGUI() {
//        setTitle("FTP Client");
//        setSize(600, 400);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        // Khởi tạo FTPClient
//        ftpClient = new FTPClient();
//
//        // Panel đăng nhập
//        JPanel loginPanel = new JPanel();
//        loginPanel.setLayout(new GridLayout(5, 2));
//
//        loginPanel.add(new JLabel("FTP Server Address:"));
//        txtFTPAddress = new JTextField("localhost");
//        loginPanel.add(txtFTPAddress);
//
//        loginPanel.add(new JLabel("Port:"));
//        txtPort = new JTextField("2121");
//        loginPanel.add(txtPort);
//
//        loginPanel.add(new JLabel("Username:"));
//        txtUsername = new JTextField("admin");
//        loginPanel.add(txtUsername);
//
//        loginPanel.add(new JLabel("Password:"));
//        txtPassword = new JPasswordField("admin123");
//        loginPanel.add(txtPassword);
//
//        btnLogin = new JButton("Login");
//        loginPanel.add(new JLabel()); // Chỗ trống
//        loginPanel.add(btnLogin);
//
//        add(loginPanel, BorderLayout.NORTH);
//
//        // Kết nối và đăng nhập vào FTP server khi nhấn "Login"
//        btnLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String ftpAddress = txtFTPAddress.getText().trim();
//                int port = Integer.parseInt(txtPort.getText().trim());
//                String username = txtUsername.getText().trim();
//                String password = new String(txtPassword.getPassword()).trim();
//
//                try {
//                    ftpClient.connect(ftpAddress, port);  // Kết nối đến FTP server
//                    boolean loginSuccess = ftpClient.login(username, password); // Đăng nhập vào FTP server
//                    if (loginSuccess) {
//                        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);  // Thiết lập kiểu file
//                        fetchFileList();  // Lấy danh sách file sau khi đăng nhập thành công
//                    } else {
//                        JOptionPane.showMessageDialog(FTPClientGUI.this, "Đăng nhập thất bại. Kiểm tra lại thông tin.");
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(FTPClientGUI.this, "Lỗi kết nối FTP: " + ex.getMessage());
//                }
//            }
//        });
//
//        // Tạo JTable để hiển thị danh sách file
//        String[] columnNames = {"File Name", "Size"};
//        fileTable = new JTable(new Object[0][0], columnNames);  // Khởi tạo JTable rỗng
//        JScrollPane scrollPane = new JScrollPane(fileTable);
//
//        // Thêm bảng vào giao diện
//        add(scrollPane, BorderLayout.CENTER);
//    }
//
//    // Lấy danh sách file từ server FTP và hiển thị trong JTable
//    private void fetchFileList() {
//        try {
//            String[] fileNames = ftpClient.listNames();  // Lấy danh sách tên file trên server
//            Object[][] data = new Object[fileNames.length][2];
//            for (int i = 0; i < fileNames.length; i++) {
//                // Lấy kích thước file (ví dụ chỉ lấy kích thước file)
//                data[i][0] = fileNames[i];
//                data[i][1] = ftpClient.mlistFile(fileNames[i]).getSize(); // Lấy kích thước file
//            }
//
//            // Cập nhật JTable với dữ liệu file
//            fileTable.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"File Name", "Size"}));
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách file: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FTPClientGUI().setVisible(true);
//            }
//        });
//    }
//}
