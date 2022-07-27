package com.its.board_text_table.service;

import com.its.board_text_table.dto.BoardDTO;
import com.its.board_text_table.entity.BoardEntity;
import com.its.board_text_table.repository.BoardReposoitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardReposoitory boardReposoitory;

    public Long save(BoardDTO boardDTO) {
    BoardEntity boardEntity =  BoardEntity.toSaveEnitty(boardDTO);
         Long  saveId = boardReposoitory.save(boardDTO);
         return saveId;
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList=boardReposoitory.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity :boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public BoardDTO  findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity =boardReposoitory.findById(id);
        if(optionalBoardEntity.isPresent()){
            return BoardDTO.toBoardDTO(optionalBoardEntity.get());
        }else{
            return null;
        }
    }
}
