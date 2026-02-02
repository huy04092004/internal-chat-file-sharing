package it.davidenastri.clouddrive.controller;

import it.davidenastri.clouddrive.model.File;
import it.davidenastri.clouddrive.model.Link;
import it.davidenastri.clouddrive.services.FileService;
import it.davidenastri.clouddrive.services.LinkService;
import it.davidenastri.clouddrive.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/shared")
public class LinkController {

    private final LinkService linkService;
    private final UserService userService;
    private final FileService fileService;


    public LinkController(LinkService linkService, UserService userService, FileService fileService) {
        this.linkService = linkService;
        this.userService = userService;
        this.fileService = fileService;

    }

    @PostMapping("/create-folder-link")
    public String createFolderLink(@RequestParam("folderId") int folderId,
                                   Principal principal,
                                   Model model) {
        int userId = userService.getUserIdByUsername(principal.getName());
        Link link = linkService.createShareableLink(userId, null, folderId, null);

        model.addAttribute("shareableLink", "/shared/folder/" + link.getLinkUrl());
        return "link_success";
    }

    @GetMapping("/folder/{linkUrl}")
    public String accessSharedFolder(@PathVariable("linkUrl") String linkUrl, Model model) {
        linkUrl = linkUrl.trim();
        // Lấy Link bằng linkUrl từ database
        Link link = linkService.getLinkByUrl(linkUrl);

        // Kiểm tra nếu không tìm thấy link
        if (link == null) {
            return "redirect:/error?message=Link%20not%20found";
        }

        // Lấy folderId từ link
        Integer folderId = link.getFolderId();

        // Lấy danh sách file từ folderId
        List<File> files = fileService.getFilesByFolderId(folderId);

        // Thêm danh sách files vào model để hiển thị trên giao diện
        model.addAttribute("files", files);

        // Trả về tên của giao diện 'shared_folder' để hiển thị danh sách file
        return "shared_folder";
    }



}
