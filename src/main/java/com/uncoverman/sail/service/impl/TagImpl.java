package com.uncoverman.sail.service.impl;

import com.uncoverman.sail.model.domain.Tag;
import com.uncoverman.sail.repository.TagRepository;
import com.uncoverman.sail.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}
