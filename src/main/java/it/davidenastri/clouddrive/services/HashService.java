package it.davidenastri.clouddrive.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String getHashedValue(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matches(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }
}
