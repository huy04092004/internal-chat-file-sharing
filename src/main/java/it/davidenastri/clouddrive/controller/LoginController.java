package it.davidenastri.clouddrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Files;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping
    public String loginView() {
        return "login";  // Trang hiển thị form đăng nhập
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        try {
            // Tạo đối tượng xác thực
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
//            session.setAttribute("CURRENT_USERNAME", username);

            // Lưu trạng thái đăng nhập vào SecurityContext nếu xác thực thành công
            SecurityContextHolder.getContext().setAuthentication(authentication);


            // Chuyển hướng tới trang chính nếu đăng nhập thành công
            return "redirect:/home";
        } catch (Exception e) {
            // Nếu có lỗi, quay lại trang đăng nhập và có thông báo lỗi
            return "redirect:/login?error";
        }
    }
}
