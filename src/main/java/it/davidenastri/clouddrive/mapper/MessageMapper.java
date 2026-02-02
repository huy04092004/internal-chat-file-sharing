package it.davidenastri.clouddrive.mapper;


import it.davidenastri.clouddrive.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    // Chèn tin nhắn vào cơ sở dữ liệu
    @Insert("INSERT INTO messages (sender_id, receiver_id, content) VALUES (#{senderId}, #{receiverId}, #{content})")
    void insertMessage(@Param("senderId") int senderId, @Param("receiverId") int receiverId, @Param("content") String content);

    // Truy vấn tin nhắn giữa hai người dùng
    @Select("SELECT m.message_id AS messageId, " +
            "       m.content AS content, " +
            "       m.created_at AS createdAt, " +
            "       u1.username AS senderUsername, " +
            "       u2.username AS receiverUsername " +
            "FROM messages m " +
            "LEFT JOIN users u1 ON m.sender_id = u1.user_id " +
            "LEFT JOIN users u2 ON m.receiver_id = u2.user_id " +
            "WHERE (m.sender_id = #{senderId} AND m.receiver_id = #{receiverId}) " +
            "   OR (m.sender_id = #{receiverId} AND m.receiver_id = #{senderId}) " +
            "ORDER BY m.created_at ASC")
    @org.apache.ibatis.annotations.Results({
            @org.apache.ibatis.annotations.Result(property = "messageId", column = "messageId"),
            @org.apache.ibatis.annotations.Result(property = "content", column = "content"),
            @org.apache.ibatis.annotations.Result(property = "createdAt", column = "createdAt"),
            @org.apache.ibatis.annotations.Result(property = "senderUsername", column = "senderUsername"),
            @org.apache.ibatis.annotations.Result(property = "receiverUsername", column = "receiverUsername")
    })
    List<Message> getMessages(@Param("senderId") int senderId, @Param("receiverId") int receiverId);

}
