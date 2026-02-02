package it.davidenastri.clouddrive.mapper;

import it.davidenastri.clouddrive.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // Thêm người dùng mới
    @Insert("INSERT INTO USERS (username, password, public_key, created_at) " +
            "VALUES(#{username}, #{password}, #{publicKey}, CURRENT_TIMESTAMP)")
    @Options(useGeneratedKeys = true, keyProperty = "userId")  // sử dụng userId là keyProperty
    int create(User user);

    // Ánh xạ kết quả từ bảng USERS tới lớp User
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "publicKey", column = "public_key"),
            @Result(property = "createdAt", column = "created_at")
    })
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    // Lấy user_id theo username
    @Select("SELECT user_id FROM USERS WHERE username = #{username}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "publicKey", column = "public_key"),
            @Result(property = "createdAt", column = "created_at")
    })
    Integer getUserIdByUsername(String username);
}
