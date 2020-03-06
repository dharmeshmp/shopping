package com.example.shopping.service;

import com.example.shopping.exception.InvalidEmailException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private String mobileRegex = "^[6-9]\\d{9}$";

    private final PasswordEncoder passwordEncoder;

    public MyUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.contains("@")) {
            Pattern pattern = Pattern.compile(emailRegex);
            if (!pattern.matcher(username).matches()) {
                throw new InvalidEmailException("Invalid email address");
            }
        } else {
            Pattern pattern = Pattern.compile(mobileRegex);
            if (!pattern.matcher(username).matches()) {
                throw new InvalidEmailException("Invalid mobile number");
            }
        }

        if (username.equals("9999999999") || username.equals("admin@admin.com")) {
            return User.builder()
                    .username(username)
                    .password(passwordEncoder.encode("admin"))
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("email or mobile number not found");
        }
    }
}
