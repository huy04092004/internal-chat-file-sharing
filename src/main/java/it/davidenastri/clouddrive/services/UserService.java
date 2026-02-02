package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.mapper.UserMapper;
import it.davidenastri.clouddrive.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    // Kiểm tra nếu username có sẵn trong cơ sở dữ liệu
    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;  // Nếu trả về null thì username chưa có
    }

    // Tạo người dùng mới
    public int create(User user) {
        String hashedPassword = hashService.getHashedValue(user.getPassword());

        // Tạo public key (có thể thay thế bằng cách tạo khóa thực tế nếu cần)
        String publicKey = "GeneratedPublicKey";

        // Tạo User mới và gọi method create của mapper
        User newUser = new User(user.getUsername(), hashedPassword, publicKey);
        return userMapper.create(newUser);
    }

    // Lấy thông tin người dùng theo username
    public User get(String username) {
        return userMapper.getUser(username);  // Trả về đối tượng User từ cơ sở dữ liệu
    }

    public Integer getUserIdByUsername(String username) {
        return userMapper.getUserIdByUsername(username);
    }

}
