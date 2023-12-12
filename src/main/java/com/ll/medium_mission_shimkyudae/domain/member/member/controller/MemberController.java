package com.ll.medium_mission_shimkyudae.domain.member.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("/join")
    public String showJoin(){
        return "domain/member/member/join";
    }

    public static class JoinForm {
        private String username;
        private String password;
    }

    @PostMapping("join")
    public String signup(JoinForm joinForm) {
        return "redirect:/";
    }
}