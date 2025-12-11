package com.example.board_project.controller;

import com.example.board_project.dto.UserDto;
import com.example.board_project.entity.User;
import com.example.board_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping
    public ResponseEntity<UserDto.Response> registerUser(@RequestBody UserDto.RegisterRequest request) {
        User registeredUser = userService.registerUser(
                request.getUsername(),
                request.getPassword(),
                request.getEmail()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(UserDto.Response.from(registeredUser));
    }

    // 사용자 ID 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto.Response> getUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(UserDto.Response.from(user));
    }
}
