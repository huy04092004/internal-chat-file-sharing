package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.mapper.UserMapper;
import it.davidenastri.clouddrive.model.Message;
import it.davidenastri.clouddrive.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageMapper messageMapper;
    private final UserMapper userMapper;

    public MessageService(MessageMapper messageMapper, UserMapper userMapper) {
        this.messageMapper = messageMapper;
        this.userMapper = userMapper;
    }

    /**
     * Lưu tin nhắn vào cơ sở dữ liệu.
     * @param senderId ID của người gửi
     * @param receiverId ID của người nhận
     * @param content Nội dung tin nhắn
     */
    public void saveMessage(int senderId, int receiverId, String content) {
        try {
            messageMapper.insertMessage(senderId, receiverId, content);
        } catch (Exception e) {
            // Ghi lại lỗi vào log hoặc xử lý thêm nếu cần
            System.err.println("Lỗi khi lưu tin nhắn: " + e.getMessage());
        }
    }

    /**
     * Lấy lịch sử trò chuyện giữa hai người dùng.
     * @param username1 Tên người dùng 1
     * @param username2 Tên người dùng 2
     * @return Danh sách các tin nhắn giữa 2 người dùng
     */
    public List<Message> getChatHistory(String username1, String username2) {
        try {
            Integer senderId = userMapper.getUserIdByUsername(username1);
            Integer receiverId = userMapper.getUserIdByUsername(username2);
            return messageMapper.getMessages(senderId, receiverId);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy lịch sử tin nhắn: " + e.getMessage());
            return null;
        }
    }
}
