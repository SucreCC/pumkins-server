package com.pumkins.repository;

import com.pumkins.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: dengKai
 * @Date: 2022-02-05-23-27
 * @Description:
 */

public interface BlogRepository extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {
}
