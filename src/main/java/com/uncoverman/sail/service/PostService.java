package com.uncoverman.sail.service;

import com.uncoverman.sail.model.domain.Post;

import java.util.List;

public interface PostService {

	Post savePost(Post post);
//	Post updatePost(Post post);
//	Post findById(Long postId);
	void deletePost(Long postId);
	List<Post> findAllPosts();
}
