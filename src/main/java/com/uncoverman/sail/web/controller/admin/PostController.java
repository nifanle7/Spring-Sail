package com.uncoverman.sail.web.controller.admin;

import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.model.dto.ResponseBo;
import com.uncoverman.sail.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/admin/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping("/save")
	@ResponseBody
	public ResponseBo save(@ModelAttribute Post post, HttpSession httpSession){
		log.info(post.getPostTitle());
		postService.savePost(post);
		return ResponseBo.ok("成功");
	}

	@RequestMapping("/post")
	public String post(){
		return "admin/post";
	}
}
