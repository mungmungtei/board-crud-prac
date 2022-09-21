package com.judy.crud.service;

import com.judy.crud.domain.Board;
import com.judy.crud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void boardWrite(Board board) {
        boardRepository.save(board);
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board boardDetail(Long id) {
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Long id) {
        boardRepository.deleteById(id);
    }

}
