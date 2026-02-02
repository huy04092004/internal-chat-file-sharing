//package it.davidenastri.clouddrive.config;
//
//import org.apache.ftpserver.FtpServer;
//import org.apache.ftpserver.FtpServerFactory;
//import org.apache.ftpserver.listener.ListenerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FtpServerConfig {
//
//    @Bean
//    public FtpServer ftpServer() throws Exception {
//        FtpServerFactory serverFactory = new FtpServerFactory();
//        ListenerFactory factory = new ListenerFactory();
//        factory.setPort(2121); // Cổng FTP
//
//        serverFactory.addListener("default", factory.createListener());
//        FtpServer server = serverFactory.createServer();
//        server.start();
//        return server;
//    }
//}
