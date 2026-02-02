package it.davidenastri.clouddrive.mapper;

import it.davidenastri.clouddrive.model.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendMapper {

    @Insert("INSERT INTO friends (user_id, friend_user_id, status) VALUES (#{userId}, #{friendUserId}, #{status})")
    void insertFriendRequest(Friend friend);

    @Select("SELECT * FROM friends WHERE user_id = #{userId} AND friend_user_id = #{friendUserId}")
    @Results({
            @Result(property = "friendId", column = "friend_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "friendUserId", column = "friend_user_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdAt", column = "created_at")
    })
    Friend getFriendRequest(@Param("userId") int userId, @Param("friendUserId") int friendUserId);

    @Select("""
    SELECT 
        f.friend_id AS friendId, 
        f.user_id AS userId, 
        f.friend_user_id AS friendUserId, 
        f.status, 
        u.username AS friendUsername 
    FROM 
        friends f 
    JOIN 
        users u 
    ON 
        f.user_id = u.user_id 
    WHERE 
        f.friend_user_id = #{userId} 
        AND f.status = 'pending'
""")
    @Results({
            @Result(property = "friendId", column = "friendId"),
            @Result(property = "userId", column = "userId"),
            @Result(property = "friendUserId", column = "friendUserId"),
            @Result(property = "status", column = "status"),
            @Result(property = "friendUsername", column = "friendUsername") // Ánh xạ friendUsername
    })
    List<Friend> getPendingFriendRequests(@Param("userId") int userId);


    @Select("""
    SELECT 
        f.friend_id AS friendId, 
        f.user_id AS userId, 
        f.friend_user_id AS friendUserId, 
        f.status, 
        u.username AS friendUsername 
    FROM 
        friends f 
    JOIN 
        users u 
    ON 
        (f.user_id = u.user_id OR f.friend_user_id = u.user_id)
    WHERE 
        (f.user_id = #{userId} AND f.status = 'accepted')
        OR (f.friend_user_id = #{userId} AND f.status = 'accepted')
""")
    @Results({
            @Result(property = "friendId", column = "friendId"),
            @Result(property = "userId", column = "userId"),
            @Result(property = "friendUserId", column = "friendUserId"),
            @Result(property = "status", column = "status"),
            @Result(property = "friendUsername", column = "friendUsername")
    })
    List<Friend> getFriendsList(@Param("userId") int userId);

    @Update("UPDATE friends SET status = #{status} WHERE friend_id = #{friendId} AND friend_user_id = #{userId}")
    @Results({
            @Result(property = "friendId", column = "friendId"),
            @Result(property = "userId", column = "userId"),
            @Result(property = "friendUserId", column = "friendUserId"),
            @Result(property = "status", column = "status"),
            @Result(property = "friendUsername", column = "friendUsername") // Ánh xạ friendUsername
    })
    void updateFriendRequestStatus(@Param("friendId") int friendId, @Param("userId") int userId, @Param("status") String status);
    @Delete("""
    DELETE FROM friends 
    WHERE 
        (user_id = #{userId} AND friend_user_id = #{friendUserId}) 
        OR (user_id = #{friendUserId} AND friend_user_id = #{userId})
""")
    void deleteFriend(@Param("userId") int userId, @Param("friendUserId") int friendUserId);

}
