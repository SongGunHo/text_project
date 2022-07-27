package com.its.board_text_table.controller;

import com.its.board_text_table.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class commentCotroller {
    private final CommentService commentService;
}
