package com.uncoverman.sail.web.controller.admin;

import com.uncoverman.sail.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/tag/list")
    @ResponseBody
    public Map<String,Object> tagList(){
        Map<String,Object> r = new HashMap<>();
        r.put("tags",tagService.findAll());
        return r;
    }
}
