package it.davidenastri.clouddrive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JTextArea txtStatus;

    public LoginPage() {
        setTitle("Login - FTP Server");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        loginPanel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        loginPanel.add(txtUsername);

        loginPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        loginPanel.add(txtPassword);

        btnLogin = new JButton("Login");
        loginPanel.add(new JLabel());
        loginPanel.add(btnLogin);

        // Khu vực hiển thị trạng thái
        txtStatus = new JTextArea(5, 30);
        txtStatus.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtStatus);

        add(loginPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Xử lý sự kiện đăng nhập
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                // Kiểm tra thông tin đăng nhập
                if ("admin".equals(username) && "admin123".equals(password)) {
                    txtStatus.append("Login successful!\n");
                    // Mở trang chính (FTP Server) và đóng trang đăng nhập
                    openMainPage();
                    dispose(); // Đóng cửa sổ đăng nhập
                } else {
                    txtStatus.append("Invalid login credentials.\n");
                }
            }
        });
    }

    // Mở trang chính (FTP Server)
    private void openMainPage() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FTPServerGUI().setVisible(true); // Mở GUI chính
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true); // Mở trang đăng nhập
            }
        });
    }
}
