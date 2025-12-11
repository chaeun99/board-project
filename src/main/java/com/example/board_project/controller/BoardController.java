package com.example.board_project.controller;

import com.example.board_project.dto.BoardDto;
import com.example.board_project.entity.Board;
import com.example.board_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class BoardController {
    private final BoardService boardService;

    // 모든 게시판 목록 조회
    @GetMapping
    public ResponseEntity<List<BoardDto.Response>> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();

        List<BoardDto.Response> responseList = boards.stream()
                .map(BoardDto.Response::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    // ID로 게시판 각각 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDto.Response> getBoardById(@PathVariable Long boardId) {
        Board board = boardService.getBoardById(boardId);
        return ResponseEntity.ok(BoardDto.Response.from(board));
    }


}
