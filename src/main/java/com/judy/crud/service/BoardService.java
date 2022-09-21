package com.judy.crud.service;

import com.judy.crud.domain.Board;
import com.judy.crud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void boardWrite(Board board) {
        boardRepository.save(board);
    }

//    public void boardWrite(Board board, MultipartFile file) throws Exception {
//
//        // 파일을 저장할 경로 지정
//        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
//
//        // 랜덤으로 식별자 생성
//        UUID uuid = UUID.randomUUID();
//
//        // 원래 파일 이름에 랜덤으로 생성된 식별자를 더해줘서 파일 이름 중복 방지
//        String fileName = uuid + "_" + file.getOriginalFilename();
//
//        // 매개변수로 들어오는 file 을 넣을 빈 껍데기 savedFile 생성
//        // -> 해당 파일을 projectPath 경로에다가 위에서 생성한 fileName 으로 넣어주기
//        File savedFile = new File(projectPath, fileName);
//
//        file.transferTo(savedFile);
//
//        board.setFileName(fileName);
//        board.setFilePath("/files/" + fileName);
//
//        boardRepository.save(board);
//    }

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
