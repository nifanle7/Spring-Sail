package com.uncoverman.sail.web.controller.admin;

import com.uncoverman.sail.common.Layui;
import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.model.dto.ResponseBo;
import com.uncoverman.sail.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/admin/post")
public class PostController{

	@Autowired
	private PostService postService;

	@GetMapping("")
	public String index() {
		return "admin/post_list";
	}

	@PostMapping("/list")
	@ResponseBody
	public Map<String,Object> postList(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
									   @RequestParam(value = "limit", defaultValue = "10") Integer pageSize){

		// JPA的分页是从0开始
		Pageable pageable = PageRequest.of(pageNum-1,pageSize, Sort.by("postId").ascending());
		Page<Post> posts = postService.findAll(pageable);
		return Layui.data(posts);

	}

	@PostMapping("/search")
	@ResponseBody
	public Map<String,Object> searchPost(@ModelAttribute Post post,
										 @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
										 @RequestParam(value = "limit", defaultValue = "10") Integer pageSize
	){
		Pageable pageable = PageRequest.of(pageNum-1,pageSize);
		Page<Post> posts = postService.search(post,pageable);
		return Layui.data(posts);
	}

	@GetMapping("/toAdd")
	public String toAdd() {
		return "admin/post_add";
	}

	@PostMapping("/add")
	@ResponseBody
	public ResponseBo save(@ModelAttribute Post post) {
		postService.save(post);
		return ResponseBo.ok("新增成功");
	}

	@GetMapping("/toEdit")
	public String toEdit(@RequestParam("postId") Long postId, Model model) {
		Post post = postService.findByPostId(postId);
		model.addAttribute("post",post);
		return "admin/post_edit";
	}

	@PostMapping("/edit")
	@ResponseBody
	public ResponseBo update(@ModelAttribute Post post){
		postService.update(post);
		return ResponseBo.ok("修改成功");
	}

	@PostMapping("/delete")
	@ResponseBody
	public ResponseBo delete(String postIds){
		String [] postIdStr = postIds.split(",");
		List<Long> postIdList = new ArrayList<>();
		for (String str:postIdStr){
			postIdList.add(Long.valueOf(str));
		}
		postService.deleteByPostIdIn(postIdList);
		return ResponseBo.ok("删除成功");
	}

}

