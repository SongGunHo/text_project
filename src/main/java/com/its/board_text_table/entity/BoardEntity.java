package com.its.board_text_table.entity;

import com.its.board_text_table.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "board_text_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String boardId;
    @Column(length = 10,nullable = false)
    private String boardTitle;
    @Column
    private String boardWriter;
    @Column(length = 500,nullable = true)
    private String boardContents;
    @Column
    private int boardHits;
    @Column
    private
    LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;
    @OneToMany(mappedBy = "boardEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public static BoardEntity toSaveEnitty(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardId(boardDTO.getBoardId());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardEntity.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }

    public static BoardDTO toBoardEntity(List<BoardDTO> boardDTOList) {
        BoardDTO boardDTO =new BoardDTO();
        boardDTO.setBoardId(boardDTO.getBoardId());
        boardDTO.setBoardTitle(boardDTO.getBoardTitle());
        boardDTO.setBoardWriter(boardDTO.getBoardWriter());
        boardDTO.setBoardHits(0);
        return boardDTO;
    }
}
