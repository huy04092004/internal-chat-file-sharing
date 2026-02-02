//package it.davidenastri.clouddrive.mapper;
//
//import it.davidenastri.clouddrive.model.Folder;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface FolderMapper {
//    @Insert("INSERT INTO folders (folder_name, user_id, created_at) VALUES (#{folderName}, #{userId}, NOW())")
//    @Options(useGeneratedKeys = true, keyProperty = "folderId")
//    int createFolder(Folder folder);
//
//    @Select("SELECT * FROM folders WHERE user_id = #{userId}")
//    @Results({
//            @Result(property = "folderId", column = "folder_id"),
//            @Result(property = "folderName", column = "folder_name"),
//            @Result(property = "userId", column = "user_id"),
//            @Result(property = "createdAt", column = "created_at")
//    })
//    List<Folder> getFoldersByUserId(int userId);
//
//    @Delete("DELETE FROM folders WHERE folder_id = #{folderId}")
//    @Results({
//            @Result(property = "folderId", column = "folder_id"),
//            @Result(property = "folderName", column = "folder_name"),
//            @Result(property = "userId", column = "user_id"),
//            @Result(property = "createdAt", column = "created_at")
//    })
//    int deleteFolder(int folderId);
//}

package it.davidenastri.clouddrive.mapper;

import it.davidenastri.clouddrive.model.Folder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FolderMapper {

    /**
     * Thêm thư mục mới
     *
     * @param folder Đối tượng Folder chứa thông tin thư mục
     * @return Số hàng bị ảnh hưởng (thường là 1)
     */
    @Insert("INSERT INTO folders (folder_name, user_id, created_at) VALUES (#{folderName}, #{userId}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "folderId")
    int insertFolder(Folder folder);

    /**
     * Lấy danh sách thư mục theo userId
     *
     * @param userId ID người dùng
     * @return Danh sách thư mục
     */
    @Select("SELECT * FROM folders WHERE user_id = #{userId}")
    @Results({
            @Result(property = "folderId", column = "folder_id"),
            @Result(property = "folderName", column = "folder_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "createdAt", column = "created_at")
    })
    List<Folder> getFoldersByUserId(int userId);

    /**
     * Lấy chi tiết một thư mục theo folderId
     *
     * @param folderId ID thư mục
     * @return Đối tượng Folder hoặc null nếu không tìm thấy
     */
    @Select("SELECT * FROM folders WHERE folder_id = #{folderId}")
    @Results({
            @Result(property = "folderId", column = "folder_id"),
            @Result(property = "folderName", column = "folder_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "createdAt", column = "created_at")
    })
    Folder getFolderById(int folderId);

    /**
     * Xóa thư mục theo folderId
     *
     * @param folderId ID thư mục
     * @return Số hàng bị ảnh hưởng (thường là 1 nếu xóa thành công)
     */
    @Delete("DELETE FROM folders WHERE folder_id = #{folderId}")
    int deleteFolder(int folderId);
}
