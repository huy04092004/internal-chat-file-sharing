package it.davidenastri.clouddrive.mapper;

import it.davidenastri.clouddrive.model.Link;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LinkMapper {

    @Insert("INSERT INTO LINKS (link_url, file_id, folder_id, expires_at, created_by) " +
            "VALUES (#{linkUrl}, #{fileId}, #{folderId}, #{expiresAt}, #{createdBy})")
    @Options(useGeneratedKeys = true, keyProperty = "linkId")
    void insertLink(Link link);
    @Select("SELECT * FROM LINKS WHERE link_url = #{linkUrl}")
    @Results({
            @Result(column = "link_id", property = "linkId"),
            @Result(column = "link_url", property = "linkUrl"),
            @Result(column = "file_id", property = "fileId"),
            @Result(column = "folder_id", property = "folderId"),
            @Result(column = "expires_at", property = "expiresAt"),
            @Result(column = "created_by", property = "createdBy"),
            @Result(column = "created_at", property = "createdAt")
    })
    Link getLinkByUrl(String linkUrl);

    @Select("SELECT * FROM LINKS WHERE link_id = #{linkId}")
    @Results({
            @Result(column = "link_id", property = "linkId"),
            @Result(column = "link_url", property = "linkUrl"),
            @Result(column = "file_id", property = "fileId"),
            @Result(column = "folder_id", property = "folderId"),
            @Result(column = "expires_at", property = "expiresAt"),
            @Result(column = "created_by", property = "createdBy"),
            @Result(column = "created_at", property = "createdAt")
    })
    Link getLinkById(int linkId);

    @Select("SELECT * FROM LINKS WHERE created_by = #{userId}")
    List<Link> getLinksByUser(int userId);



    @Delete("DELETE FROM LINKS WHERE link_id = #{linkId}")
    void deleteLink(int linkId);
}
