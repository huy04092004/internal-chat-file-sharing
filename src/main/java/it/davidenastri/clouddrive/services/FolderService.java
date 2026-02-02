//package it.davidenastri.clouddrive.services;
//
//import it.davidenastri.clouddrive.mapper.FolderMapper;
//import it.davidenastri.clouddrive.model.Folder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FolderService {
//
//    private final FolderMapper folderMapper;
//
//    public FolderService(FolderMapper folderMapper) {
//        this.folderMapper = folderMapper;
//    }
//
//    // Sửa lại phương thức để nhận folderName và userId
//    public int createFolder(String folderName, int userId) {
//        Folder folder = new Folder();
//        folder.setFolderName(folderName);
//        folder.setUserId(userId);
//        return folderMapper.createFolder(folder);
//    }
//
//    public List<Folder> getFoldersByUserId(int userId) {
//
//        List<Folder> folders = folderMapper.getFoldersByUserId(userId);
////        System.out.println(folders);  // Log kiểm tra
//        return folders;
//    }
//
//    public int deleteFolder(int folderId) {
//        return folderMapper.deleteFolder(folderId);
//    }
//}
package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.mapper.FolderMapper;
import it.davidenastri.clouddrive.model.Folder;
import it.davidenastri.clouddrive.model.Link;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Service
public class FolderService {

        private final FolderMapper folderMapper;
        private final LinkService linkService;

        public FolderService(FolderMapper folderMapper, LinkService linkService) {
            this.folderMapper = folderMapper;
            this.linkService = linkService;
        }


        /**
     * Tạo một thư mục mới cho người dùng
     *
     * @param folderName Tên thư mục
     * @param userId     ID của người dùng
     * @return ID của thư mục vừa tạo
     */
    public int createFolder(String folderName, int userId) {
        Folder folder = new Folder();
        folder.setFolderName(folderName);
        folder.setUserId(userId);

        // Gọi mapper để thêm thư mục và trả về ID
        folderMapper.insertFolder(folder);
        return folder.getFolderId();
    }

    /**
     * Lấy danh sách thư mục của một người dùng
     *
     * @param userId ID người dùng
     * @return Danh sách các thư mục
     */
    public List<Folder> getFoldersByUserId(int userId) {
        return folderMapper.getFoldersByUserId(userId);
    }

    /**
     * Lấy chi tiết một thư mục
     *
     * @param folderId ID thư mục
     * @return Đối tượng Folder hoặc null nếu không tìm thấy
     */
    public Folder getFolderById(int folderId) {
        return folderMapper.getFolderById(folderId);
    }

    /**
     * Xóa thư mục theo ID
     *
     * @param folderId ID thư mục
     * @return Số lượng hàng bị ảnh hưởng (0 nếu không xóa được)
     */
    public int deleteFolder(int folderId) {
        return folderMapper.deleteFolder(folderId);
    }
//    public String generateShareableLink(int folderId, int userId) {
//        // Kiểm tra xem folderId có hợp lệ không
//        Folder folder = getFolderById(folderId);
//        if (folder == null || folder.getUserId() != userId) {
//            throw new IllegalArgumentException("Invalid folder or access denied");
//        }
//
//        // Tạo URL ngẫu nhiên
//        String linkUrl = UUID.randomUUID().toString();
//
//        // Lưu link vào cơ sở dữ liệu
//        Link link = new Link();
//        link.setLinkUrl(linkUrl);
//        link.setFolderId(folderId);
//        link.setCreatedBy(userId);
////        linkMapper.insertLink(link); // Nếu bạn dùng MyBatis
//
//
//        return "/folders/shared/" + linkUrl; // Trả về link đầy đủ
//    }

}
