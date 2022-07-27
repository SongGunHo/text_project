package com.its.board_text_table.entity;

import com.its.board_text_table.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10,nullable = false)
    private String memberEmail;

    @Column(length = 10,nullable = false)
    private String memberPassword;

    @Column(length = 5, nullable = true)
    private String memberName;

    @Column
    private int memberAge;
    @Column
    private String memberMobile;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEnitty = new MemberEntity();
        memberEnitty.setMemberEmail(memberDTO.getMemberEmile());
        memberEnitty.setMemberPassword(memberDTO.getMemberPassword());
        memberEnitty.setMemberName(memberEnitty.getMemberName());
        memberEnitty.setMemberAge(0);
        memberEnitty.setMemberMobile(memberDTO.getMemberMobile());
        return memberEnitty;
    }
}
