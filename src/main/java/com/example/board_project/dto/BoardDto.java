package com.example.board_project.dto;

import com.example.board_project.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BoardDto {
    @Data
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String name;
        private String description;

        public static Response from(Board board) {
            return Response.builder()
                    .id(board.getId())
                    .name(board.getName())
                    .description(board.getDescription())
                    .build();
        }
    }
}
