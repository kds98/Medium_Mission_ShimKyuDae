package com.ll.medium_mission_shimkyudae.domain.member.member.repository;

import com.ll.medium_mission_shimkyudae.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
