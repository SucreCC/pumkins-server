package com.pumkins.restful.service.blogComment.impl;

import com.pumkins.dto.request.BlogCommentReq;
import com.pumkins.dto.resp.BlogCommentResp;
import com.pumkins.entity.BlogComment;
import com.pumkins.entity.QBlogComment;
import com.pumkins.repository.BlogCommentRepository;
import com.pumkins.restful.service.blogComment.BlogCommentService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/01/22 16:16
 * @description: TODO
 */
@Component
public class BlogCommentServiceImpl implements BlogCommentService {

    private final static QBlogComment Q_BLOG_COMMENT = QBlogComment.blogComment;

    private final static Integer BLOG_ID_ZERO = 0;

    @Autowired
    private BlogCommentRepository blogCommentRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public void save(BlogCommentReq blogCommentReq) {
        blogCommentRepository.save(blogCommentReq.build());
    }

    @Override
    public List<BlogCommentResp> getBlogCommentByBlogId(Integer blogId) {
        List<BlogCommentResp> blogCommentRespList = jpaQueryFactory.selectFrom(Q_BLOG_COMMENT)
            .where(Q_BLOG_COMMENT.blogId.eq(blogId))
            .where(Q_BLOG_COMMENT.parentId.eq(BLOG_ID_ZERO))
            .orderBy(Q_BLOG_COMMENT.createDate.desc(),Q_BLOG_COMMENT.numberOfThumbUp.desc())
            .fetchAll()
            .stream()
            .map(BlogCommentResp::build)
            .collect(Collectors.toList());
        return getSubComment(blogCommentRespList, blogId);
    }

    @Override
    public void deleteBlogCommentByBlogId(Integer id) {
        blogCommentRepository.deleteById(id);
    }

    private List<BlogCommentResp> getSubComment(List<BlogCommentResp> blogCommentRespList, Integer blogId) {

        blogCommentRespList.forEach(blogCommentResp -> {
            List<BlogCommentResp> subCommentList = jpaQueryFactory.selectFrom(Q_BLOG_COMMENT)
                .where(Q_BLOG_COMMENT.parentId.eq(blogCommentResp.getId()))
                .where(Q_BLOG_COMMENT.blogId.eq(blogId))
                .orderBy(Q_BLOG_COMMENT.createDate.asc())
                .fetchAll()
                .stream()
                .map(BlogCommentResp::build)
                .collect(Collectors.toList());
            blogCommentResp.setSubComment(subCommentList);
        });
        return blogCommentRespList;
    }
}
