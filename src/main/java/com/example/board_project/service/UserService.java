package com.example.board_project.service;

import com.example.board_project.entity.User;
import com.example.board_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public User registerUser(String username, String password, String email) {
        User newUser = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
        return userRepository.save(newUser);
    }

    // ID로 사용자 조회
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. " + userId));
    }

}
