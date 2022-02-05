package com.pumkins.repository;

import com.pumkins.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * @author: dengKai
 * @date: 2021/12/03 16:23
 * @description: TODO
 */
@Component
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
