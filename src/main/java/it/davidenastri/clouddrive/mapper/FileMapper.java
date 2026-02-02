package it.davidenastri.clouddrive.mapper;

import it.davidenastri.clouddrive.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    // Thêm file vào cơ sở dữ liệu
    @Insert("INSERT INTO files (file_name, content_type, file_size, file_hash, user_id, folder_id, created_at) " +
            "VALUES (#{fileName}, #{contentType}, #{fileSize}, #{fileHash}, #{userId}, #{folderId}, CURRENT_TIMESTAMP)")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int uploadFile(File file);

    // Lấy danh sách file theo folder_id
    @Select("SELECT * FROM files WHERE folder_id = #{folderId}")
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileName", column = "file_name"),
            @Result(property = "contentType", column = "content_type"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "fileHash", column = "file_hash"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "folderId", column = "folder_id"),
            @Result(property = "createdAt", column = "created_at")
    })
    List<File> getFilesByFolderId(int folderId);

    // Xóa file theo file_id
    @Delete("DELETE FROM files WHERE file_id = #{fileId}")
    int deleteFile(int fileId);

    // Lấy file theo file_id
    @Select("SELECT * FROM files WHERE file_id = #{fileId}")
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileName", column = "file_name"),
            @Result(property = "contentType", column = "content_type"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "fileHash", column = "file_hash"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "folderId", column = "folder_id"),
            @Result(property = "createdAt", column = "created_at")
    })
    File getFileById(int fileId);

    // Lấy danh sách file của người dùng theo user_id
    @Select("SELECT * FROM files WHERE user_id = #{userId}")
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileName", column = "file_name"),
            @Result(property = "contentType", column = "content_type"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "fileHash", column = "file_hash"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "folderId", column = "folder_id"),
            @Result(property = "createdAt", column = "created_at")
    })
    List<File> getFilesByUserId(int userId);
}
