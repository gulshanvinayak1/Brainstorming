package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Jwt.JwtUtil;
import com.ghanshyam.Brainstroming.Repository.UserRepository;
import com.ghanshyam.Brainstroming.entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public UserService() {
    }

    public String signUp(User user) {
        if (this.userRepository.findByGmailId(user.getGmailId()).isPresent()) {
            return "Email already in use";
        } else if (this.userRepository.findByUserId(user.getUserId()).isPresent()) {
            return "User ID already in use";
        } else {
            this.userRepository.save(user);
            return "User registered successfully";
        }
    }

    public String signIn(String userId, String password) {
        Optional<User> userOptional = this.userRepository.findByUserId(userId);
        if (userOptional.isEmpty()) {
            return "User not found";
        } else {
            User user = (User)userOptional.get();
            return !password.equals(user.getPassword()) ? "Invalid credentials" : this.jwtUtil.generateToken("username");
        }
    }
}
