package com.its.board_text_table.controller;

import com.its.board_text_table.dto.BoardDTO;
import com.its.board_text_table.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/save-form")
    private String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(BoardDTO boardDTO){
        Long save = boardService.save(boardDTO);
        return "redice:/board";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> all =boardService.findAll();
        model.addAttribute("board",all);
        return "detail";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable("id")Long id){
         BoardDTO byId =boardService.findById(id);
         return "detail";

    }

}
