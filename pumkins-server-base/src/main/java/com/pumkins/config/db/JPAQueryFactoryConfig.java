package com.pumkins.config.db;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author: dengKai
 * @date: 2021/12/04 14:25
 * @description:
 *
 * 生成JPAQueryFactory对象，之前在JpaConfig配置生成这个对象，在update/delete的时候会出现
 * Executing an update/delete query 的错误异常
 */
@Configuration
public class JPAQueryFactoryConfig {
    @Bean
    @Autowired
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
