package it.davidenastri.clouddrive.config;

import it.davidenastri.clouddrive.services.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // Sử dụng AuthenticationService như một AuthenticationProvider
        auth.authenticationProvider(this.authenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)        // Xóa session khi logout
                .deleteCookies("JSESSIONID");      // Xóa cookie khi logout

        http.authorizeRequests()
                // Cấu hình những trang không yêu cầu đăng nhập
                .antMatchers("/css/**", "/js/**", "/signup", "/logout", "/h2-console/**","/images/**").permitAll()
                .antMatchers("/folders/**").authenticated()  // Cần đăng nhập để truy cập các thư mục
                .antMatchers("/friends/**").authenticated()  // Trang friends cần đăng nhập

                .anyRequest().authenticated(); // Các request khác phải đăng nhập

        // Cấu hình csrf và headers cho H2 console
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // Cấu hình form login
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home"); // Redirect tới trang home sau khi đăng nhập thành công
    }


    // Định nghĩa bean AuthenticationManager
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
