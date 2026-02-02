-- Bảng USERS để lưu thông tin người dùng, bao gồm mật khẩu
CREATE TABLE IF NOT EXISTS users (
                                     user_id INT PRIMARY KEY AUTO_INCREMENT,
                                     username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,                   -- Thêm trường password
    public_key VARCHAR(512) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT username_unique UNIQUE (username)
    );

-- Bảng FRIENDS để lưu thông tin kết bạn giữa các người dùng
CREATE TABLE IF NOT EXISTS friends (
                                       friend_id INT PRIMARY KEY AUTO_INCREMENT,
                                       user_id INT NOT NULL,
                                       friend_user_id INT NOT NULL,
                                       status ENUM('pending', 'accepted', 'blocked') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (friend_user_id) REFERENCES users(user_id)
    );

-- Bảng FOLDERS để lưu trữ các thư mục mà người dùng muốn chia sẻ
CREATE TABLE IF NOT EXISTS folders (
                                       folder_id INT PRIMARY KEY AUTO_INCREMENT,
                                       folder_name VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
    );

-- Bảng FILES để lưu trữ thông tin về tệp chia sẻ
CREATE TABLE IF NOT EXISTS files (
                                     file_id INT PRIMARY KEY AUTO_INCREMENT,
                                     file_name VARCHAR(255) NOT NULL,
    content_type VARCHAR(50),  -- Loại tệp (ví dụ: image/png, application/pdf, ...)
    file_size INT,
    file_hash VARCHAR(255),  -- Hash của tệp để xác minh tính toàn vẹn
    user_id INT NOT NULL,
    folder_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (folder_id) REFERENCES folders(folder_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
    );

-- Bảng SHARE_PERMISSIONS để lưu quyền chia sẻ các tệp và thư mục
CREATE TABLE IF NOT EXISTS share_permissions (
                                                 permission_id INT PRIMARY KEY AUTO_INCREMENT,
                                                 file_id INT,  -- Liên kết đến tệp (nếu có)
                                                 folder_id INT,  -- Liên kết đến thư mục (nếu có)
                                                 shared_with INT NOT NULL,  -- Người dùng được chia sẻ
                                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                 FOREIGN KEY (file_id) REFERENCES files(file_id),
    FOREIGN KEY (folder_id) REFERENCES folders(folder_id),
    FOREIGN KEY (shared_with) REFERENCES users(user_id)
    );

-- Bảng LINKS để tạo và quản lý các link chia sẻ thư mục hoặc tệp
CREATE TABLE IF NOT EXISTS links (
                                     link_id INT PRIMARY KEY AUTO_INCREMENT,
                                     link_url VARCHAR(255) UNIQUE NOT NULL,  -- Đường dẫn link chia sẻ
    file_id INT,  -- Liên kết đến tệp (nếu có)
    folder_id INT,  -- Liên kết đến thư mục (nếu có)
    expires_at TIMESTAMP,  -- Thời gian hết hạn của link chia sẻ
    created_by INT NOT NULL,  -- Người tạo link chia sẻ
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (file_id) REFERENCES files(file_id),
    FOREIGN KEY (folder_id) REFERENCES folders(folder_id),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
    );