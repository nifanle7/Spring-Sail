package com.uncoverman.sail.common;

import org.springframework.data.domain.Page;

import java.util.HashMap;

public class Layui extends HashMap<String,Object>{

    public static Layui data(Page<?> page){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", page.getTotalElements());
        r.put("data", page.getContent());
        return r;
    }
}
