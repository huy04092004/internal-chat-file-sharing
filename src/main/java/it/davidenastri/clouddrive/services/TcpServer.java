//package it.davidenastri.clouddrive.services;
//
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//@Service
//public class TcpServer {
//
//    public void start(int port) {
//        new Thread(() -> {
//            try (ServerSocket serverSocket = new ServerSocket(port)) {
//                System.out.println("TCP Server is running on port " + port);
//                while (true) {
//                    Socket clientSocket = serverSocket.accept();
//                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//                    String message = in.readLine();
//                    System.out.println("Received: " + message);
//                    out.println("Acknowledged: " + message);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }
//}
