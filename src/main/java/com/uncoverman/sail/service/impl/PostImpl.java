package com.uncoverman.sail.service.impl;

import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.repository.PostRepository;
import com.uncoverman.sail.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Page<Post> findAll(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public Post findByPostId(Long postId) {
		return postRepository.findByPostId(postId);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void update(Post post) {
		postRepository.save(post);
	}

	@Override
	public void deleteByPostId(Long postId) {
		postRepository.deleteById(postId);
	}

	@Override
	@Transactional
	public void deleteByPostIdIn(List<Long> postIds) {
		postRepository.deleteByPostIdIn(postIds);
	}


}
