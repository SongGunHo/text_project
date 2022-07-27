package com.its.board_text_table.controller;

import com.its.board_text_table.dto.MemberDTO;
import com.its.board_text_table.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(MemberDTO memberDTO){
       Long saveId =  memberService.save(memberDTO);
       return "login";
    }
    @GetMapping("/login-form")
    public String loginForm(){
        return "login";
    }
    @PostMapping("/login")
    public String login(MemberDTO memberDTO, HttpSession session){
        final MemberDTO login = memberService.login(memberDTO);
        if(login != null){
            session.setAttribute("login",login.getId());
            session.setAttribute("login",login);
            return "list";
        }else{
            return "login";
        }
    }
    @GetMapping("/list")
    public String list(Model model){
         List<MemberDTO> all =memberService.findAll();
         model.addAttribute("all",all);
         return "list";
    }
    @GetMapping("/${id}")
    public String detail(@PathVariable("id")Long id){
        memberService.findById(id);
    }
}
