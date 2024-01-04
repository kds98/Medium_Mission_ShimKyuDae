package com.ll.medium_mission_shimkyudae.global.init;

import com.ll.medium_mission_shimkyudae.domain.member.member.entity.Member;
import com.ll.medium_mission_shimkyudae.domain.member.member.service.MemberService;
import com.ll.medium_mission_shimkyudae.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.stream.IntStream;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class NotProd {
    private final MemberService memberService;
    private final PostService postService;
    @Bean
    @Order(3)
    public ApplicationRunner initNotProd() {
        return args -> {
            if (memberService.findByUsername("user1").isPresent()) return;

            Member memberUser1 = memberService.join("user1", "1234", true).getData();
            Member memberUser2 = memberService.join("user2", "1234", false).getData();
            Member memberUser3 = memberService.join("user3", "1234", false).getData();
            Member memberUser4 = memberService.join("user4", "1234", true).getData();

            postService.write(memberUser1, "제목 1", "내용 1", true, true);
            postService.write(memberUser1, "제목 2", "내용 2", true, true);
            postService.write(memberUser1, "제목 3", "내용 3", false, false);
            postService.write(memberUser1, "제목 4", "내용 4", true, false);

            postService.write(memberUser2, "제목 5", "내용 5", true, true);
            postService.write(memberUser2, "제목 6", "내용 6", false, false);

            IntStream.rangeClosed(7, 50).forEach(i -> {
                postService.write(memberUser3, "제목 " + i, "내용 " + i, true, true);
            });
            IntStream.rangeClosed(51, 100).forEach(i -> {
                postService.write(memberUser4, "제목 " + i, "내용 " + i, true, false);
            });
        };
    }
}