package it.davidenastri.clouddrive;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.PropertiesUserManager;

import java.io.File;

public class FtpServerManager {
    private FtpServer ftpServer;

    public void startServer() throws Exception {
        if (ftpServer != null && !ftpServer.isStopped()) {
            throw new IllegalStateException("FTP Server is already running");
        }

        try {
            // Tạo user manager trực tiếp trong mã
            PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
            File userPropertiesFile = new File("src/main/resources/myusers.properties");

            // Kiểm tra nếu file cấu hình người dùng không tồn tại, bạn có thể tự tạo user manager
            if (!userPropertiesFile.exists()) {
                throw new IllegalStateException("File myusers.properties không tồn tại: " + userPropertiesFile.getAbsolutePath());
            }

            userManagerFactory.setFile(userPropertiesFile);

            // Tạo user FTP đơn giản
            BaseUser user = new BaseUser();
            user.setName("admin");
            user.setPassword("admin123");
            user.setHomeDirectory("D:/a"); // Chỉ định thư mục gốc

            // Thêm quyền ghi bằng cách sử dụng PropertiesUserManager
//            user.setWritePermission(true); // Đảm bảo rằng quyền ghi được set đúng

            // Sử dụng PropertiesUserManager để quản lý người dùng
            PropertiesUserManager userManager = (PropertiesUserManager) userManagerFactory.createUserManager();

            // Lưu người dùng vào manager (nếu người dùng đã tồn tại, sẽ ghi đè)
//            userManager.save(user);

            // Cấu hình FTP server
            FtpServerFactory serverFactory = new FtpServerFactory();
            serverFactory.setUserManager(userManager);

            // Cấu hình Listener cho FTP Server
            ListenerFactory listenerFactory = new ListenerFactory();
            listenerFactory.setPort(2121); // Cổng FTP

            serverFactory.addListener("default", listenerFactory.createListener());

            // Tạo và chạy FTP Server
            ftpServer = serverFactory.createServer();
            ftpServer.start();

            System.out.println("FTP Server đã khởi động trên cổng 2121");
        } catch (Exception e) {
            System.err.println("Lỗi khi khởi động FTP Server: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void stopServer() {
        if (ftpServer != null && !ftpServer.isStopped()) {
            ftpServer.stop();
            ftpServer = null;
        }
    }
}
