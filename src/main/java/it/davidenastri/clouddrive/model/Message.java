package it.davidenastri.clouddrive.model;

import java.time.LocalDateTime;

public class Message {
    private Long messageId;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    private LocalDateTime createdAt;

    private String senderUsername;
    private String receiverUsername;

    // Getters và Setters
    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", senderUsername='" + senderUsername + '\'' +  // Hiển thị tên người gửi
                ", receiverUsername='" + receiverUsername + '\'' + // Hiển thị tên người nhận
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
