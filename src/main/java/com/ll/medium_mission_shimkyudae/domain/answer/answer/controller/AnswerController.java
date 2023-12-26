package com.ll.medium_mission_shimkyudae.domain.answer.answer.controller;

import com.ll.medium_mission_shimkyudae.domain.answer.answer.service.AnswerService;
import com.ll.medium_mission_shimkyudae.domain.post.post.entity.Post;
import com.ll.medium_mission_shimkyudae.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final PostService postService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value = "content") String content) {
        Post post = this.postService.getPost(id);
        this.answerService.create(post, content);

        return String.format("redirect:/question/detail/%s", id);
    }
}
