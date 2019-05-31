package com.uncoverman.sail.service.impl;

import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.repository.PostRepository;
import com.uncoverman.sail.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

//	简单查询全部列表
	@Override
	public Page<Post> findAll(Pageable pageable) {
		return postRepository.findAll(pageable);
	}


	@Override
	public Page<Post> search(Post post, Pageable pageable){
		return postRepository.findAll((Root<Post> root, CriteriaQuery<?> CriteriaQuery,CriteriaBuilder criteriaBuilder)->{
			Predicate predicate = null;
			if (post.getPostTitle() != null){
				predicate = criteriaBuilder.equal(root.get("postTitle"),post.getPostTitle());
			}
			return predicate;
		},pageable);
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
