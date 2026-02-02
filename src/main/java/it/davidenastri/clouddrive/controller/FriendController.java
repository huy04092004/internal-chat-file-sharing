package it.davidenastri.clouddrive.controller;

import it.davidenastri.clouddrive.P2PClient;
import it.davidenastri.clouddrive.model.Friend;
import it.davidenastri.clouddrive.services.FriendService;
import it.davidenastri.clouddrive.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;
    private final UserService userService;

    public FriendController(FriendService friendService, UserService userService) {
        this.friendService = friendService;
        this.userService = userService;
    }


    @PostMapping("/send-request")
    public ResponseEntity<String> sendFriendRequest(@RequestParam String username, @RequestParam String friendUsername) {
        Integer userId = userService.getUserIdByUsername(username);
        Integer friendUserId = userService.getUserIdByUsername(friendUsername);

        if (userId == null || friendUserId == null) {
            return ResponseEntity.badRequest().body("User not found.");
        }

        try {
            friendService.sendFriendRequest(userId, friendUserId);
            return ResponseEntity.ok("Friend request sent successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/pending-requests")
    public ResponseEntity<List<Friend>> getPendingRequests(@RequestParam String username) {
        Integer userId = userService.getUserIdByUsername(username);
        if (userId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Friend> pendingRequests = friendService.getPendingFriendRequests(userId);
        return ResponseEntity.ok(pendingRequests);
    }

    @PostMapping("/respond-request")
    public ResponseEntity<String> respondToFriendRequest(
            @RequestParam int friendId,
            @RequestParam String status,
            HttpSession session) { // Thêm session làm tham số
        String currentUsername = (String) session.getAttribute("CURRENT_USERNAME");

        // Kiểm tra username trong session
        if (currentUsername == null) {
            return ResponseEntity.badRequest().body("Session expired. Please log in again.");
        }

        Integer userId = userService.getUserIdByUsername(currentUsername);
        if (userId == null) {
            return ResponseEntity.badRequest().body("User not found.");
        }

        try {
            // Cập nhật trạng thái kết bạn cho cả hai chiều
            friendService.respondToFriendRequest(userId, friendId, status); // Cập nhật từ người gửi
            friendService.respondToFriendRequest(friendId, userId, status); // Cập nhật từ người nhận

            return ResponseEntity.ok("Friend request " + status + " successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/friends")
    public String showFriendsPage(HttpSession session, Model model) {
        // Lấy username từ session
        String currentUsername = (String) session.getAttribute("CURRENT_USERNAME");
        if (currentUsername == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }

        Integer userId = userService.getUserIdByUsername(currentUsername);
        List<Friend> pendingRequests = friendService.getPendingFriendRequests(userId);

        model.addAttribute("username", currentUsername);
        model.addAttribute("pendingRequests", pendingRequests);

        return "friend"; // Trả về trang friend.html
    }
    @GetMapping("/friends/view")
    public String showFriendsPage2(HttpSession session, Model model) {
        // Lấy username từ session
        String currentUsername = (String) session.getAttribute("CURRENT_USERNAME");

        if (currentUsername == null) {
            return "redirect:/login"; // Nếu chưa đăng nhập, chuyển hướng đến trang login
        }

        // Lấy userId từ username
        Integer userId = userService.getUserIdByUsername(currentUsername);
        if (userId == null) {
            return "redirect:/login"; // Nếu không tìm thấy userId, chuyển hướng đến trang login
        }

        // Lấy danh sách bạn bè của người dùng
        List<Friend> friends = friendService.getFriendsList(userId);
//        if (friends == null) {
//            friends = new ArrayList<>();
//        }
        friends.removeIf(friend -> friend.getFriendUsername().equals(currentUsername));

        // Thêm danh sách bạn bè vào model để truyền vào trang HTML
        model.addAttribute("username", currentUsername);
        model.addAttribute("friends", friends);

        return "friends"; // Trả về trang friends.html
    }
//
//    @DeleteMapping("/delete/{friendUserId}")
//    public ResponseEntity<String> deleteFriend(@PathVariable int friendUserId, @RequestHeader("userId") int userId) {
//        friendService.deleteFriend(userId, friendUserId); // userId được lấy từ Header hoặc Authentication
//        return ResponseEntity.ok("Friend deleted successfully.");
//    }
@PostMapping("/delete")
public String deleteFriend(@RequestParam("friendUserId") int friendUserId, Principal principal) {
    // Lấy thông tin user hiện tại từ Principal
    String username = principal.getName();
    int userId = userService.getUserIdByUsername(username);
    System.out.println("Deleting friend for userId: " + userId + ", friendUserId: " + friendUserId);

    // Kiểm tra bạn bè có tồn tại không và có thuộc về người dùng hiện tại không
//    Friend friend = friendService.getFriendByUserAndFriend(userId, friendUserId);
//    if (friend == null) {
//        return "redirect:/friends?error=Friend%20not%20found%20or%20access%20denied";
//    }

    // Thực hiện xóa bạn
    friendService.deleteFriend(userId, friendUserId);
    return "redirect:/friends/friends/view?success=Friend%20deleted%20successfully";
}



}
