package com.uncoverman.sail.service;

import com.uncoverman.sail.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

	Page<Post> findAll(Pageable pageable);
	Post findByPostId(Long postId);
	Post save(Post post);
	void update(Post post);
	void deleteByPostId(Long postId);
	void deleteByPostIdIn(List<Long> postIds);

}
