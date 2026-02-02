
package it.davidenastri.clouddrive.controller;

import it.davidenastri.clouddrive.model.File;
import it.davidenastri.clouddrive.model.Folder;
import it.davidenastri.clouddrive.model.Link;
import it.davidenastri.clouddrive.services.FileService;
import it.davidenastri.clouddrive.services.FolderService;
import it.davidenastri.clouddrive.services.LinkService;
import it.davidenastri.clouddrive.services.UserService;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import org.springframework.core.io.Resource;


    /**
     * Tạo thư mục mới
     */
    @Controller
    @RequestMapping("/folders") // Sửa /api/folders thành /folders
    public class FolderController {

        // Các dịch vụ khác
        private final FolderService folderService;
        private final UserService userService;
        private final FileService fileService;
        private final LinkService linkService;  // Thêm trường này


        public FolderController(FolderService folderService, FileService fileService, UserService userService,LinkService linkService ) {
            this.folderService = folderService;
            this.userService = userService;
            this.fileService = fileService;
            this.linkService = linkService;  // Inject LinkService vào controller

        }

        @PostMapping("/create")
        public String createFolder(@RequestParam("folderName") String folderName, Principal principal) {
            String username = principal.getName();
            int userId = userService.getUserIdByUsername(username);

            int folderId = folderService.createFolder(folderName, userId);
            return "redirect:/folders/folder/" + folderId; // Đảm bảo URL đúng
        }

        @GetMapping("/user")
        public String getFoldersByUser(Model model, Principal principal) {
            String username = principal.getName();
            int userId = userService.getUserIdByUsername(username);

            List<Folder> folders = folderService.getFoldersByUserId(userId);
            model.addAttribute("folders", folders);
            return "home"; // Trang home.html hợp lệ
        }

            @PostMapping("/files/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("folderId") int folderId,
                             Principal principal) {
        try {
            String username = principal.getName();
            int userId = userService.getUserIdByUsername(username);

            // Gọi dịch vụ để lưu tệp
            fileService.uploadFile(file, userId, folderId);

        } catch (IOException e) {
            e.printStackTrace(); // Log lỗi nếu cần
            return "error"; // Trả về trang lỗi hoặc thông báo lỗi
        }

//        return "redirect:/folder"; // Quay lại trang chủ
                return "redirect:/folders/folder/" + folderId;

            }
        @GetMapping("/folder/{folderId}")
        public String viewFolder(@PathVariable int folderId, Model model) {
            Folder folder = folderService.getFolderById(folderId);
            if (folder == null) {
                return "redirect:/folders?error=Folder%20not%20found"; // Sửa đường dẫn
            }

            List<File> files = fileService.getFilesByFolderId(folderId);
            model.addAttribute("folder", folder);
            model.addAttribute("files", files);
            return "folder"; // Trang folder.html hợp lệ
        }
        @PostMapping("/files/delete")
        public String deleteFile(@RequestParam("fileId") int fileId,
                                 @RequestParam("folderId") int folderId,  // Thêm folderId
                                 Principal principal) throws IOException {
            File file = fileService.getFileById(fileId);
            if (file == null) {
                return "redirect:/folders/folder/" + folderId + "?error=File not found.";
            }

            String username = principal.getName();
            int userId = userService.getUserIdByUsername(username);

            if (file.getUserId() != userId) {
                return "redirect:/folders/folder/" + folderId + "?error=Access denied.";
            }

            fileService.deleteFile(fileId);
            return "redirect:/folders/folder/" + folderId + "?success=File deleted successfully.";
        }

        @GetMapping("/files/download-file/{fileId}")
        public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") int fileId) {
            try {
                Resource resource = fileService.downloadFile(fileId);  // Gọi phương thức download từ FileService
                String fileName = resource.getFilename();

                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                        .body(resource);
            } catch (IOException e) {
                return ResponseEntity.status(500).body(null);  // Trả về lỗi nếu có vấn đề khi tải file
            }
        }


        @PostMapping("/delete")
        public String deleteFolder(@RequestParam("folderId") int folderId, Principal principal) {
            String username = principal.getName();
            int userId = userService.getUserIdByUsername(username);

            Folder folder = folderService.getFolderById(folderId);
            if (folder == null || folder.getUserId() != userId) {
                return "redirect:/folders/user?error=Folder%20not%20found%20or%20access%20denied"; // Đảm bảo đường dẫn đúng
            }

            folderService.deleteFolder(folderId);
            return "redirect:/folders/user?success=Folder%20deleted%20successfully"; // Đảm bảo đường dẫn đúng
        }
        @GetMapping("/shared/folder/{folderId}")
        public String viewSharedFolder(@PathVariable int folderId, Model model) {
            Folder folder = folderService.getFolderById(folderId);
            if (folder == null) {
                return "redirect:/folders/user?error=Folder%20not%20found";
            }

            List<File> files = fileService.getFilesByFolderId(folderId);
            model.addAttribute("files", files); // Chỉ gửi danh sách file đến giao diện
            System.out.println("Files: " + files);

            return "shared-folder"; // Giao diện dành riêng cho các liên kết chia sẻ
        }

        @PostMapping("/shared/generate")
        public String generateShareableLink(@RequestParam("folderId") int folderId, Principal principal, Model model) {
            String username = principal.getName();
            int userId = userService.getUserIdByUsername(username);

            // Kiểm tra xem thư mục có thuộc về người dùng hiện tại không
            Folder folder = folderService.getFolderById(folderId);
            if (folder == null || folder.getUserId() != userId) {
                return "redirect:/folders/user?error=Folder%20not%20found%20or%20access%20denied";
            }

            // Tạo link chia sẻ bằng LinkService với fileId và expiresAt là null
            Link link = linkService.createShareableLink(userId, null, folderId, null);

            // Gửi link tới giao diện
            model.addAttribute("shareableLink", "/folders/shared/" + link.getLinkUrl());

            return "redirect:/folders/folder/" + folderId + "?success=Shareable link generated.";
        }


    }
