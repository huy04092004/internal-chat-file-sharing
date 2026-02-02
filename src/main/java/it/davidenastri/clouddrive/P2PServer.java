package it.davidenastri.clouddrive;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class P2PServer implements Runnable {
    private final int port;

    public P2PServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("P2P Server is running on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection from: " + socket.getInetAddress().getHostAddress());

                // Tạo luồng xử lý mỗi khi có kết nối
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket socket) {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            // Đọc loại yêu cầu (nhắn tin hoặc gửi file)
            String requestType = dis.readUTF();
            if ("SEND_MESSAGE".equals(requestType)) {
                handleMessage(dis);
            } else if ("SEND_FILE".equals(requestType)) {
                handleFile(dis);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }

    private void handleMessage(DataInputStream dis) throws IOException {
        String sender = dis.readUTF();
        String message = dis.readUTF();
        System.out.println("Received message from " + sender + ": " + message);
    }

    private void handleFile(DataInputStream dis) throws IOException {
        String fileName = dis.readUTF(); // Tên file
        long fileSize = dis.readLong();  // Kích thước file
        String saveDir = "D:/mang_may_tinh/"; // Thư mục lưu file
        File dir = new File(saveDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Lưu file vào thư mục
        File file = new File(saveDir + File.separator + fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            long remaining = fileSize;

            while ((bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, remaining))) > 0) {
                fos.write(buffer, 0, bytesRead);
                remaining -= bytesRead;
            }
        }
        System.out.println("File received and saved as: " + file.getAbsolutePath());
    }
}
