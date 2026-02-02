//package it.davidenastri.clouddrive;
//
//import org.apache.ftpserver.FtpServer;
//import org.apache.ftpserver.FtpServerFactory;
//import org.apache.ftpserver.listener.ListenerFactory;
//import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
//
//import java.io.File;
//
//public class FTPServerHandler {
//
//    public static void main(String[] args) {
//        try {
//            // Tạo Factory cho User Manager
//            PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
//            userManagerFactory.setFile(new File("src/main/resources/myusers.properties")); // Đường dẫn tới tệp cấu hình
//
//            // Cấu hình và khởi động server FTP
//            FtpServerFactory serverFactory = new FtpServerFactory();
//            serverFactory.setUserManager(userManagerFactory.createUserManager());
//
//            ListenerFactory listenerFactory = new ListenerFactory();
//            listenerFactory.setPort(2121); // Cổng FTP, ví dụ cổng 21
//            serverFactory.addListener("default", listenerFactory.createListener());
//
//            FtpServer server = serverFactory.createServer();
//            server.start();
//
//            System.out.println("FTP Server started on port 2121");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
