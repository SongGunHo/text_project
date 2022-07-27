package com.its.board_text_table.repository;

import com.its.board_text_table.dto.MemberDTO;
import com.its.board_text_table.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
     MemberDTO login(MemberDTO memberDTO);
     MemberDTO findByEmail(String memberEmile);

     Optional<MemberEntity>  findBymemberEmail(String memberEmile);

}
