package com.uncoverman.sail.web.controller.admin;

import com.uncoverman.sail.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("admin/category/list")
    @ResponseBody
    public Map<String,Object> findAll(){
        Map<String,Object> r = new HashMap<>();
        r.put("categories", categoryService.findAll());
        return r;
    }
}
