package it.davidenastri.clouddrive.controller;

import it.davidenastri.clouddrive.P2PClient;
import it.davidenastri.clouddrive.model.Message;
import it.davidenastri.clouddrive.services.MessageService;
import it.davidenastri.clouddrive.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {
    private final UserService userService;
    private final MessageService messageService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam String friendUsername,
                                         @RequestParam String messageContent,
                                         HttpSession session) {
        String currentUsername = (String) session.getAttribute("CURRENT_USERNAME");

        // Kiểm tra session hợp lệ
        if (currentUsername == null) {
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "Session expired"));
        }

        try {
            // Gửi tin nhắn qua P2P
            P2PClient p2pClient = new P2PClient();
            String friendIp = "172.20.10.2"; // Địa chỉ IP của bạn bè
            int friendPort = 12347; // Cổng P2P của bạn bè

            boolean p2pSuccess = p2pClient.sendMessage(friendIp, friendPort, messageContent);
            if (!p2pSuccess) {
                return ResponseEntity.status(500).body(Collections.singletonMap("error", "P2P message sending failed"));
            }

            // Lưu tin nhắn vào cơ sở dữ liệu
            messageService.saveMessage(
                    userService.getUserIdByUsername(currentUsername),
                    userService.getUserIdByUsername(friendUsername),
                    messageContent
            );
            return ResponseEntity.ok(Collections.singletonMap("message", "Message sent successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "Failed to send message"));
        }
    }

    @GetMapping("/chat")
    public String chatPage(@RequestParam String friendUsername, Model model, HttpSession session) {
        // Lấy tên người dùng hiện tại từ session
        String currentUsername = (String) session.getAttribute("CURRENT_USERNAME");

        if (currentUsername == null) {
            // Nếu session hết hạn, chuyển hướng đến trang đăng nhập
            return "redirect:/login";
        }

        // Lấy lịch sử tin nhắn giữa hai người
        List<Message> chatHistory = messageService.getChatHistory(currentUsername, friendUsername);

        // Thêm thông tin vào model để hiển thị trên giao diện
        model.addAttribute("friendUsername", friendUsername);
        model.addAttribute("currentUsername", currentUsername);
        model.addAttribute("messages", chatHistory);

        // Trả về trang HTML
        return "message";
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestMessages(@RequestParam String friendUsername, HttpSession session) {
        String currentUsername = (String) session.getAttribute("CURRENT_USERNAME");

        // Kiểm tra session hợp lệ
        if (currentUsername == null) {
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "Session expired"));
        }

        try {
            // Lấy lịch sử tin nhắn
            List<Message> chatHistory = messageService.getChatHistory(currentUsername, friendUsername);
            return ResponseEntity.ok(chatHistory); // Trả về dữ liệu JSON
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "Failed to retrieve messages"));
        }
    }




}
