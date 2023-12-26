package com.ll.medium_mission_shimkyudae.domain.answer.answer.service;

import com.ll.medium_mission_shimkyudae.domain.answer.answer.entity.Answer;
import com.ll.medium_mission_shimkyudae.domain.answer.answer.repository.AnswerRepository;
import com.ll.medium_mission_shimkyudae.domain.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Post post, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setPost(post);
        this.answerRepository.save(answer);
    }
}
