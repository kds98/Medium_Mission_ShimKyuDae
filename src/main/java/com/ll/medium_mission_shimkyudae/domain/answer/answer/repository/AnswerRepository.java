package com.ll.medium_mission_shimkyudae.domain.answer.answer.repository;

import com.ll.medium_mission_shimkyudae.domain.answer.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
