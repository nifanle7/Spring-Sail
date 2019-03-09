package com.uncoverman.sail.web.controller.admin;

import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.model.dto.ResponseBo;
import com.uncoverman.sail.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/post")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping("")
	public String index() {
		return "admin/post_list";
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Post> findAllPost() {
		return postService.findAllPosts();
	}

	@RequestMapping("/add")
	@ResponseBody
	public ResponseBo save(@ModelAttribute Post post, HttpSession httpSession) {
		log.info(post.getPostTitle());
		postService.savePost(post);
		return ResponseBo.ok("新增成功");
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "admin/post_edit";
	}

}

