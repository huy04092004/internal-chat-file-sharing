package it.davidenastri.clouddrive.services;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FTPService {

    public boolean uploadFile(String server, int port, String user, String password,
                              String localFilePath, String remoteFilePath) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, password);
            ftpClient.enterLocalPassiveMode(); // Chế độ thụ động để tránh lỗi firewall
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            try (FileInputStream inputStream = new FileInputStream(localFilePath)) {
                return ftpClient.storeFile(remoteFilePath, inputStream);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
