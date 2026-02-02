package it.davidenastri.clouddrive.controller;

import it.davidenastri.clouddrive.model.Folder;
import it.davidenastri.clouddrive.services.FolderService;
import it.davidenastri.clouddrive.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final FolderService folderService;
    private final UserService userService;

    public HomeController(FolderService folderService, UserService userService) {
        this.folderService = folderService;
        this.userService = userService;
    }

    /**
     * Hiển thị trang chủ
     */
    @GetMapping("/home")
    public String home(Model model, Principal principal, HttpSession session) {
        // Lấy username từ Principal hoặc session
        String username = principal.getName();
        session.setAttribute("CURRENT_USERNAME", username); // Lưu vào session
        int userId = userService.getUserIdByUsername(username);

        // Lấy danh sách thư mục của người dùng
        List<Folder> folders = folderService.getFoldersByUserId(userId);

        // Gửi thông tin vào model
        model.addAttribute("username", username);
        model.addAttribute("folders", folders);

        return "home"; // Trả về trang home.html
    }

    /**
     * Xóa thư mục
     */
    @PostMapping("/home/folders/delete")
    public String deleteFolder(@RequestParam("folderId") int folderId) {
        folderService.deleteFolder(folderId);
        return "redirect:/home"; // Quay lại trang chủ
    }
}
