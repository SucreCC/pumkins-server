package com.pumkins.repository;

import com.pumkins.entity.TimeNodeTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: dengKai
 * @Date: 2022-02-05-23-27
 * @Description:
 */
@Repository
public interface TimeNodeTagsRepository extends JpaRepository<TimeNodeTags, Integer>, JpaSpecificationExecutor<TimeNodeTags> {
}
