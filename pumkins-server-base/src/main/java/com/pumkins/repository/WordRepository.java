package com.pumkins.repository;

import com.pumkins.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author: dengKai
 * @date: 2022/02/14 11:07
 * @description:
 */

public interface WordRepository extends JpaRepository<Word, Integer> ,JpaSpecificationExecutor<Word>{
}
