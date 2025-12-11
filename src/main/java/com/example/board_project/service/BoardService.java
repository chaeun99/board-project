package com.example.board_project.service;

import com.example.board_project.entity.Board;
import com.example.board_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    // 모든 게시판 목록 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // ID로 게시판 각각 조회
    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException(boardId + "게시판을 찾을 수 없습니다."));
    }
}
