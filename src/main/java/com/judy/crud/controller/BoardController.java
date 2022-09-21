package com.judy.crud.controller;

import com.judy.crud.domain.Board;
import com.judy.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "board-write";
    }

    @PostMapping("/board/show")
    public String boardShow(Board board, Model model) {

        boardService.boardWrite(board);

        model.addAttribute("saveMessage", "글이 작성되었습니다.");
        model.addAttribute("boardListUrl", "/board/list");

       return "message/save-message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("boardList", boardService.boardList());
        return "board-list";
    }

    @GetMapping("/board/detail")
    public String boardDetail(Model model, Long id) {
        model.addAttribute("boardDetail", boardService.boardDetail(id));
        return "board-detail";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Long id, Model model) {
        boardService.boardDelete(id);
        model.addAttribute("deleteMessage", "글이 삭제되었습니다.");
        model.addAttribute("boardListUrl", "/board/list");
        return "message/delete-message";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boardDetail", boardService.boardDetail(id)); // 기존 작성 내용 보여주기
        return "board-update";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Long id, Board board, Model model) {

        Board updatedBoard = boardService.boardDetail(id); // 기존 작성 내용 담아오기 (필요한가?)
        updatedBoard.setTitle(board.getTitle());
        updatedBoard.setContent(board.getContent());

        boardService.boardWrite(updatedBoard);

        model.addAttribute("updateMessage", "글이 수정되었습니다.");
        model.addAttribute("boardListUrl", "/board/list");

        return "message/update-message";
    }
}
