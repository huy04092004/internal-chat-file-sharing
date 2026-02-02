package it.davidenastri.clouddrive;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FTPClientHandler {

    // Upload file
    public static boolean uploadFile(String server, int port, String user, String password, String filePath) {
        FTPClient ftpClient = new FTPClient();
        try {
            // Kết nối tới FTP server
            ftpClient.connect(server, port);
            if (!ftpClient.login(user, password)) {
                System.out.println("Login failed");
                return false;
            }

            // Cài đặt chế độ Passive
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Mở file và tải lên
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return false;
            }

            try (FileInputStream inputStream = new FileInputStream(file)) {
                return ftpClient.storeFile(file.getName(), inputStream);
            }
        } catch (IOException ex) {
            System.out.println("Error while uploading file: " + ex.getMessage());
            return false;
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Download file
    public static boolean downloadFile(String server, int port, String user, String password, String remoteFilePath, String localPath) {
        FTPClient ftpClient = new FTPClient();
        try {
            // Kết nối đến FTP server
            ftpClient.connect(server, port);
            if (!ftpClient.login(user, password)) {
                System.out.println("Login failed");
                return false;
            }

            // Cài đặt chế độ Passive
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Tải file từ server
            File downloadFile = new File(localPath + "/" + new File(remoteFilePath).getName());
            try (FileOutputStream outputStream = new FileOutputStream(downloadFile)) {
                return ftpClient.retrieveFile(remoteFilePath, outputStream);
            }
        } catch (IOException ex) {
            System.out.println("Error during FTP download: " + ex.getMessage());
            return false;
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
