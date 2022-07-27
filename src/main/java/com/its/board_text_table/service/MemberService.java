package com.its.board_text_table.service;

import com.its.board_text_table.dto.MemberDTO;
import com.its.board_text_table.entity.MemberEntity;
import com.its.board_text_table.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long  save(MemberDTO memberDTO) {
     Long saveId =   memberRepository.save(MemberEntity.toMemberEntity(memberDTO)).getId();
     return saveId;
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findBymemberEmail(memberDTO.getMemberEmile());
        if(optionalMemberEntity.isPresent()){
             MemberEntity memberEntity = optionalMemberEntity.get();
             if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                return  MemberDTO.toMemberDTO(memberEntity);
             }else{
                 return null;
             }
        }

    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList =memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity member : memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        }return memberDTOList;
    }

    public MemberDTO findById(Long id) {
         Optional<MemberEntity> byId =memberRepository.findById(id);
         if(byId.isPresent()){
              MemberEntity member =byId.get();
              MemberDTO memberDTO = MemberDTO.toMemberDTO(member);
         }return
    }
}
