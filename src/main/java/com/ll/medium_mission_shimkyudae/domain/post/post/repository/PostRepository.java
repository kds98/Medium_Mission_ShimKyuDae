package com.ll.medium_mission_shimkyudae.domain.post.post.repository;

import com.ll.medium_mission_shimkyudae.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findTop30ByIsPublishedOrderByIdDesc(boolean isPublished);
}