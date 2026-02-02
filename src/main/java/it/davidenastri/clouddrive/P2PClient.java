package it.davidenastri.clouddrive;

import java.io.*;
import java.net.*;
import org.apache.commons.net.ftp.FTPClient;

public class P2PClient {

    public boolean sendMessage(String targetIp, int targetPort, String message) {
        try (Socket socket = new Socket(targetIp, targetPort);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {
            out.println(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendFile(String targetIp, int targetPort, String filePath) {
        try {
            // Gửi thông báo qua P2P
            String message = "SEND_FILE " + new File(filePath).getName();
            sendMessage(targetIp, targetPort, message);

            // Gửi file qua FTP
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(targetIp, 2121);
            ftpClient.login("ftpuser", "ftpuser");
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            File localFile = new File(filePath);
            try (FileInputStream inputStream = new FileInputStream(localFile)) {
                boolean done = ftpClient.storeFile("/uploads/" + localFile.getName(), inputStream);
                return done;
            } finally {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
