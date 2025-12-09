package com.example.board_project.dto;

import com.example.board_project.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class UserDto {
    // 회원ㅏ입시 들어오는 데이터 받음
    @Data
    public static class RegisterRequest {
        private String username;
        private String password;
        private String email;
    }

    // 회원가입 결과 응답
    @Data
    @Builder
    @AllArgsConstructor
    public static class Response {
        private Long id; // 필요한가?
        private String username;
        private String email;

        public static Response from(User user) {
            return Response.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .build();
        }
    }
}
