package com.uncoverman.sail.service.impl;

import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.repository.PostRepository;
import com.uncoverman.sail.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}

//	@Override
//	public Post updatePost(Post post) {
//		Post postTmp = postRepository.findById(post.getPostId());
//	}
//
//	@Override
//	public Post findById(Long postId) {
//		return postRepository.findById(postId);
//	}

	@Override
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}
}
