package com.ll.medium_mission_shimkyudae.domain.home.home.controller;

import com.ll.medium_mission_shimkyudae.domain.post.post.service.PostService;
import com.ll.medium_mission_shimkyudae.global.rq.Rq.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final Rq rq;
    private final PostService postService;
    @GetMapping("/")
    public String showMain() {
        rq.setAttribute("posts", postService.findTop30ByIsPublishedOrderByIdDesc(true));

        return "domain/home/home/main";
    }
}