package it.davidenastri.clouddrive.controller;

import it.davidenastri.clouddrive.model.File;
import it.davidenastri.clouddrive.services.FileService;
import it.davidenastri.clouddrive.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    @Autowired
    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    // Chức năng upload file
    @PostMapping("/upload-file")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("userId") int userId,
                             @RequestParam("folderId") int folderId,
                             Model model) {
        try {
            if (file.isEmpty()) {
                model.addAttribute("message", "Please select a file to upload.");
                return "folder";
            }

            if (file.getSize() > 10485760) {
                model.addAttribute("message", "File size exceeds the maximum limit of 10 MB.");
                return "folder";
            }

            int result = fileService.uploadFile(file, userId, folderId);
            if (result > 0) {
                model.addAttribute("message", "File uploaded successfully!");
            } else {
                model.addAttribute("message", "File upload failed due to server error. Please try again.");
            }
        } catch (IOException e) {
            model.addAttribute("message", "An error occurred while uploading the file. Please contact support.");
        }

        return "redirect:/folder/" + folderId; // Trả về trang thư mục sau khi tải lên
    }

    // Chức năng xóa file
    @PostMapping("/files/delete")
    public String deleteFile(@RequestParam("fileId") int fileId,
                             @RequestParam("folderId") int folderId,
                             Principal principal,
                             Model model) throws IOException {
        File file = fileService.getFileById(fileId);
        if (file == null) {
            model.addAttribute("message", "File not found.");
            return "redirect:/folder/" + folderId;
        }

        String username = principal.getName();
        int userId = userService.getUserIdByUsername(username);

        if (file.getUserId() != userId) {
            model.addAttribute("message", "Access denied. You cannot delete this file.");
            return "redirect:/folder/" + folderId;
        }

        try {
            fileService.deleteFile(fileId);
            model.addAttribute("message", "File deleted successfully.");
        } catch (IOException e) {
            model.addAttribute("message", "An error occurred while deleting the file. Please contact support.");
        }

        return "redirect:/folder/" + folderId; // Trả về lại trang thư mục
    }
    @GetMapping("/download-file/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") int fileId) {
        try {
            // Gọi service để lấy file dưới dạng Resource
            Resource resource = fileService.downloadFile(fileId);

            // Lấy tên file
            String fileName = resource.getFilename();

            // Trả về file với các header cho phép tải về
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM) // Loại file là binary stream (tệp tin)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"") // Đính kèm file với tên
                    .body(resource); // Truyền file dưới dạng body response
        } catch (IOException e) {
            // Nếu có lỗi khi tải file, trả về lỗi 404
            return ResponseEntity.notFound().build();
        }
    }


}
