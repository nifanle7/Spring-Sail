package com.uncoverman.sail.web.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.uncoverman.sail.common.controller.BaseController;
import com.uncoverman.sail.model.domain.Post;
import com.uncoverman.sail.model.dto.QueryRequest;
import com.uncoverman.sail.model.dto.ResponseBo;
import com.uncoverman.sail.service.PostService;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/admin/post")
public class PostController extends BaseController{

	@Autowired
	private PostService postService;

	@RequestMapping("")
	public String index(HttpServletRequest request) {
		List<Post> postList = postService.findAllPosts();
		request.setAttribute("postList",postList);
		return "admin/post_list";
	}

	@RequestMapping("/add")
	@ResponseBody
	public ResponseBo save(@ModelAttribute Post post, HttpSession httpSession) {
		postService.savePost(post);
		return ResponseBo.ok("新增成功");
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "admin/post_edit";
	}

	@RequestMapping("/list")
	@ResponseBody
	public  Map<String,Object> postList(QueryRequest request){

		// JPA的分页是从0开始
		Pageable pageable = PageRequest.of(request.getPageNum()-1,request.getPageSize());
		Page<Post> posts = postService.findAllPosts(pageable);
		return getDataTable(posts);

	}

}

