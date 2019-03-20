package com.uncoverman.sail.common.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

	protected Map<String, Object> getDataTable(Page<?> page) {
		Map<String, Object> rspData = new HashMap<String, Object>();
		rspData.put("rows", page.getContent());
		rspData.put("total", page.getTotalElements());
		return rspData;
	}
}
