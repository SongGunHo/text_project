package com.its.board_text_table.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String boarId;
    private String commentTile;
    private String CommentWriter;

    public CommentDTO(String commentTile, String commentWriter) {
        this.commentTile = commentTile;
        CommentWriter = commentWriter;
    }
}
