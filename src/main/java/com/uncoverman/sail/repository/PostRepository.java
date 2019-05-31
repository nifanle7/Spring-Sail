package com.uncoverman.sail.repository;

import com.uncoverman.sail.model.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>,JpaSpecificationExecutor<Post>{
    // 基本查询分为两种，一种是spring data默认实现，一种是根据方法名来自动解析SQL
    Post findByPostId(Long postId);
    void deleteByPostIdIn(List<Long> postIds);
}
