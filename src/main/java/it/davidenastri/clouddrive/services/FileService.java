package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.mapper.FileMapper;
import it.davidenastri.clouddrive.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class FileService {

    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    // Phương thức upload file lên thư mục
    public int uploadFile(MultipartFile file, int userId, int folderId) throws IOException {
        // Kiểm tra tên file
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null || originalFileName.isEmpty()) {
            throw new IllegalArgumentException("File name is invalid.");
        }

        // Đảm bảo thư mục lưu trữ tồn tại
        Path storageDir = Paths.get("D:/mang_may_tinh/");
        if (!Files.exists(storageDir)) {
            try {
                Files.createDirectories(storageDir);
            } catch (IOException e) {
                throw new IOException("Failed to create storage directory: " + storageDir, e);
            }
        }

        // Xử lý xung đột tên file
        Path targetPath = storageDir.resolve(originalFileName);
        int counter = 1;
        while (Files.exists(targetPath)) {
            // Nếu file đã tồn tại, thêm hậu tố để tránh ghi đè
            String baseName = originalFileName.contains(".")
                    ? originalFileName.substring(0, originalFileName.lastIndexOf("."))
                    : originalFileName;
            String extension = originalFileName.contains(".")
                    ? originalFileName.substring(originalFileName.lastIndexOf("."))
                    : "";
            targetPath = storageDir.resolve(baseName + "(" + counter + ")" + extension);
            counter++;
        }

        // Lưu file vào hệ thống
        try (InputStream inputStream = file.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(targetPath.toFile())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Failed to write file to disk: " + targetPath, e);
        }

        // Lưu thông tin file vào cơ sở dữ liệu
        File fileEntity = new File();
        fileEntity.setFileName(targetPath.getFileName().toString());
        fileEntity.setUserId(userId);
        fileEntity.setFolderId(folderId);
        fileEntity.setFileHash("12"); // Thay thế bằng hàm tạo hash thực tế nếu cần
        fileEntity.setContentType(file.getContentType()); // Loại MIME
        fileEntity.setFileSize((int) file.getSize()); // Kích thước file

        int result = fileMapper.uploadFile(fileEntity);
        if (result <= 0) {
            // Xóa file nếu lưu vào cơ sở dữ liệu thất bại
            Files.deleteIfExists(targetPath);
            throw new IOException("Failed to save file metadata to database.");
        }

        return result;
    }



// ...

    public Resource downloadFile(int fileId) throws IOException {
        // Lấy thông tin file từ cơ sở dữ liệu
        File file = fileMapper.getFileById(fileId);
        if (file == null) {
            throw new IllegalArgumentException("File not found.");
        }

        // Đường dẫn tới file trong hệ thống lưu trữ
        Path filePath = Paths.get("D:/mang_may_tinh/", file.getFileName());

        // Kiểm tra xem file có tồn tại không
        if (!Files.exists(filePath)) {
            throw new IOException("File not found in storage: " + filePath);
        }

        // Trả về file dưới dạng Resource để có thể truyền cho client
        try {
            return new UrlResource(filePath.toUri());
        } catch (Exception e) {
            throw new IOException("Failed to load file as resource: " + filePath, e);
        }
    }

    // Lấy danh sách các tệp trong một thư mục
    public List<File> getFilesByFolderId(int folderId) {
        return fileMapper.getFilesByFolderId(folderId);
    }

    // Phương thức xóa file
//    public int deleteFile(int fileId) {
//        return fileMapper.deleteFile(fileId);
//    }
    public int deleteFile(int fileId) throws IOException {
        File file = fileMapper.getFileById(fileId);
        if (file == null) {
            throw new IllegalArgumentException("File not found.");
        }

        Path filePath = Paths.get("D:/mang_may_tinh/", file.getFileName());
        Files.deleteIfExists(filePath); // Xóa file khỏi hệ thống lưu trữ

        return fileMapper.deleteFile(fileId); // Xóa file khỏi cơ sở dữ liệu
    }

    // Phương thức lấy file theo ID
    public File getFileById(int fileId) {
        return fileMapper.getFileById(fileId);
    }

    // Lấy danh sách tệp của người dùng theo userId
    public List<File> getFilesByUserId(int userId) {
        return fileMapper.getFilesByUserId(userId);
    }


}
