package it.davidenastri.clouddrive.services;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

@Service
public class TcpClient {

    public void sendMessage(String ip, int port, String message) {
        try (Socket socket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isPortOpen(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            // Nếu kết nối thành công, cổng mở
            return true;
        } catch (UnknownHostException e) {
            System.out.println("Không thể tìm thấy host: " + host);
        } catch (IOException e) {
            // Nếu có lỗi khi kết nối, cổng đóng
            System.out.println("Cổng " + port + " không mở trên " + host);
        }
        return false;
    }
}
