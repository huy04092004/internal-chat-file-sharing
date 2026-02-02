package it.davidenastri.clouddrive.model;

import java.sql.Timestamp;

public class Friend {
    private int friendId;
    private int userId;
    private int friendUserId; // ID của bạn bè
    private String status;
    private String friendUsername; // Thêm thuộc tính này

    private Timestamp createdAt;

    // Getters và Setters
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(int friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
