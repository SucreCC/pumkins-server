package com.pumkins.restful.service.blogCategory.impl;

import com.pumkins.dto.request.BlogCategoryReq;
import com.pumkins.dto.resp.BlogCategoryResp;
import com.pumkins.entity.BlogCategory;
import com.pumkins.entity.QBlogCategory;
import com.pumkins.repository.BlogCategoryRepository;
import com.pumkins.restful.service.blogCategory.BlogCtegoryService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @author: dengKai
 * @date: 2023/01/19 07:22
 * @description: TODO
 */
@Component
public class BlogCategoryImpl implements BlogCtegoryService {

    private final static QBlogCategory Q_BLOG_CATEGORY = QBlogCategory.blogCategory;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    public BlogCategoryResp getCategoryByLabel(BlogCategoryReq blogCategoryReq) {
        BlogCategory blogCategory = jpaQueryFactory.selectFrom(Q_BLOG_CATEGORY)
            .where(Q_BLOG_CATEGORY.label.eq(blogCategoryReq.getLabel()))
            .fetchOne();
        return BlogCategoryResp.build(blogCategory);
    }


    @Override
    public BlogCategoryResp saveCategory(BlogCategoryReq blogCategoryReq) {
        BlogCategoryResp blogCategoryResp = getCategoryByLabel(blogCategoryReq);

        System.out.println(blogCategoryResp);
        if (blogCategoryResp.getId() != null) {
            return blogCategoryResp;
        }

        Date date = new Date();
        blogCategoryReq.setCreateDate(date)
            .setUpdateDate(date);
        BlogCategory blogCategory = blogCategoryRepository.save(blogCategoryReq.convertToBlogCategory());
        System.out.println(blogCategory);
        return BlogCategoryResp.build(blogCategory);
    }
}
