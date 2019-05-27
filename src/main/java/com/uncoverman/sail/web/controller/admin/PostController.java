package com.uncoverman.sail.web.controller.admin;

import com.uncoverman.sail.common.controller.BaseController;
import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.model.dto.QueryRequest;
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
public class PostController extends BaseController{

	@Autowired
	private PostService postService;

	@GetMapping("")
	public String index() {
		return "admin/post_list";
	}

	@PostMapping("/list")
	@ResponseBody
	public  Map<String,Object> postList(QueryRequest request){

		// JPA的分页是从0开始
		Pageable pageable = PageRequest.of(request.getPageNum()-1,request.getPageSize(), Sort.by("postId").ascending());
		Page<Post> posts = postService.findAll(pageable);
		return getDataTable(posts);

	}

	@PostMapping("/add")
	@ResponseBody
	public ResponseBo save(@ModelAttribute Post post) {
		postService.save(post);
		return ResponseBo.ok("新增成功");
	}

	@GetMapping("/addPage")
	public String addPage() {
		return "admin/post_add";
	}

	@GetMapping("/editPage")
	public String editPage(@RequestParam("postId") Long postId, Model model) {
		Post post = postService.findByPostId(postId);
		model.addAttribute("post",post);
		return "admin/post_edit";
	}

	@PostMapping("/edit")
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

