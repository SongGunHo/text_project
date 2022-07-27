package com.its.board_text_table.dto;

import com.its.board_text_table.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberEmile;
    private String memberPassword;
    private String memberName;
    private int memberAge;
    private String memberMobile;

    public MemberDTO(String memberEmile, String memberPassword, String memberName,int  memberAge, String memberMobile) {
        this.memberEmile = memberEmile;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberMobile = memberMobile;
    }


    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO  = new MemberDTO();
        memberDTO.setMemberEmile(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberAge(0);
        memberDTO.setMemberMobile(memberEntity.getMemberMobile());
        return memberDTO;
    }
}
