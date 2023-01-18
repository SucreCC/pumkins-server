package com.pumkins.repository;

import com.pumkins.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: dengKai
 * @Date: 2023-01-14-12-17
 * @Description: TODO
 */
@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer>, JpaSpecificationExecutor<Tags> {
}
