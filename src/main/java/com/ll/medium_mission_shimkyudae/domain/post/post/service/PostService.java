package com.ll.medium_mission_shimkyudae.domain.post.post.service;

import com.ll.medium_mission_shimkyudae.DataNotFoundException;
import com.ll.medium_mission_shimkyudae.domain.member.member.entity.Member;
import com.ll.medium_mission_shimkyudae.domain.post.post.entity.Post;
import com.ll.medium_mission_shimkyudae.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void write(Member author, String title, String body, boolean isPublished) {
        Post post = Post.builder()
                .author(author)
                .title(title)
                .body(body)
                .isPublished(isPublished)
                .build();

        postRepository.save(post);
    }

    public Object findTop30ByIsPublishedOrderByIdDesc(boolean isPublished) {
        return postRepository.findTop30ByIsPublishedOrderByIdDesc(isPublished);
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    public Page<Post> search(String kw, Pageable pageable) {
        return postRepository.findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(kw, kw, pageable);
    }

    public Post getPost(Integer id) {
        Optional<Post> post = this.postRepository.findById((long) id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String title, String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setCreateDate(LocalDateTime.now());
        this.postRepository.save(post);
    }
}