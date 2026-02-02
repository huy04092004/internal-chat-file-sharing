package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.mapper.FriendMapper;
import it.davidenastri.clouddrive.model.Friend;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    private final FriendMapper friendMapper;

    public FriendService(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

    // Lấy danh sách yêu cầu kết bạn đang chờ xử lý
    public List<Friend> getPendingFriendRequests(int userId) {
        List<Friend> pendingRequests = friendMapper.getPendingFriendRequests(userId);
        System.out.println("Pending Requests for userId " + userId + ": " + pendingRequests);
        return pendingRequests;
    }

    public List<Friend> getFriendsList(int userId) {
        // Giả sử friendMapper có phương thức để lấy danh sách bạn bè từ cơ sở dữ liệu
        return friendMapper.getFriendsList(userId);
    }





    // Gửi yêu cầu kết bạn
    public void sendFriendRequest(int userId, int friendUserId) {
        // Kiểm tra nếu yêu cầu đã tồn tại
        Friend existingRequest = friendMapper.getFriendRequest(userId, friendUserId);
        if (existingRequest != null) {
            throw new IllegalStateException("Friend request already exists.");
        }

        // Tạo yêu cầu mới
        Friend friendRequest = new Friend();
        friendRequest.setUserId(userId);
        friendRequest.setFriendUserId(friendUserId);
        friendRequest.setStatus("pending");

        friendMapper.insertFriendRequest(friendRequest);
    }

    // Phản hồi yêu cầu kết bạn


    public void respondToFriendRequest(int friendId, int userId, String status) {
        if (!status.equals("accepted") && !status.equals("blocked")) {
            throw new IllegalArgumentException("Invalid status. Must be 'accepted' or 'blocked'.");
        }
        friendMapper.updateFriendRequestStatus(friendId, userId, status);
//        friendMapper.updateFriendRequestStatus(userId,friendId,  status);

    }

    public void deleteFriend(int userId, int friendUserId) {
        // Kiểm tra nếu quan hệ bạn bè tồn tại
        Friend existingFriendship = friendMapper.getFriendRequest(userId, friendUserId);
        if (existingFriendship == null) {
            throw new IllegalStateException("Friendship does not exist.");
        }

        // Gọi mapper để xóa bạn
        friendMapper.deleteFriend(userId, friendUserId);
    }
}
