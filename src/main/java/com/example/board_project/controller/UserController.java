package com.example.board_project.controller;

import com.example.board_project.dto.UserDto;
import com.example.board_project.entity.User;
import com.example.board_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
