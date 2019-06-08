package com.uncoverman.sail.service.impl;

import com.uncoverman.sail.model.domain.Category;
import com.uncoverman.sail.repository.CategoryRepository;
import com.uncoverman.sail.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
