package com.uncoverman.sail.service.impl;

import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.repository.PostRepository;
import com.uncoverman.sail.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}
}
