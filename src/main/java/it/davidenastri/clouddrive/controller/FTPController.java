//package it.davidenastri.clouddrive.controller;
//
//import it.davidenastri.clouddrive.services.FTPService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//public class FTPController {
//
//    private final FTPService ftpService;
//
//    @Autowired
//    public FTPController(FTPService ftpService) {
//        this.ftpService = ftpService;
//    }
//
//    @PostMapping("/uploadFile")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
//                                             @RequestParam("friendUsername") String friendUsername) {
//        String server = "ftp.example.com"; // Thay bằng địa chỉ FTP server của bạn
//        int port = 2121; // Port FTP (mặc định là 21)
//        String user = "username"; // Tên đăng nhập FTP
//        String password = "password"; // Mật khẩu FTP
//
//        String remoteFilePath = "/uploads/" + friendUsername + "/" + file.getOriginalFilename();
//
//        try {
//            boolean success = ftpService.uploadFile(server, port, user, password, file, remoteFilePath);
//
//            if (success) {
//                return ResponseEntity.ok("File uploaded successfully: " + remoteFilePath);
//            } else {
//                return ResponseEntity.status(500).body("Failed to upload file");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
//        }
//    }
//}
