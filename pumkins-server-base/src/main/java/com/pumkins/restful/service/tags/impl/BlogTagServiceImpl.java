package com.pumkins.restful.service.tags.impl;

import com.pumkins.entity.BlogTags;
import com.pumkins.entity.QBlogTags;
import com.pumkins.restful.service.tags.BlogTagService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/01/20 20:35
 * @description: TODO
 */
@Component
public class BlogTagServiceImpl implements BlogTagService {

    private final static QBlogTags BLOG_TAGS = QBlogTags.blogTags;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Integer> getTagByBlogId(Integer blogId) {
        return jpaQueryFactory.selectFrom(BLOG_TAGS)
            .where(BLOG_TAGS.blogId.eq(blogId))
            .fetchAll()
            .stream()
            .map(BlogTags::getTagId)
            .collect(Collectors.toList());
    }
}
