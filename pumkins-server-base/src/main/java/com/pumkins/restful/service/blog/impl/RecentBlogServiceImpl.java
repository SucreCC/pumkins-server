package com.pumkins.restful.service.blog.impl;

import com.pumkins.dto.request.BlogSearchReq;
import com.pumkins.dto.resp.BlogResp;
import com.pumkins.entity.QBlog;
import com.pumkins.entity.QTags;
import com.pumkins.entity.QUser;
import com.pumkins.entity.User;
import com.pumkins.querydsl.JPAQueryWrapper;
import com.pumkins.restful.service.blog.RecentBlogService;
import com.pumkins.restful.service.blogCategory.BlogCtegoryService;
import com.pumkins.restful.service.img.BlogImageService;
import com.pumkins.restful.service.img.ImgService;
import com.pumkins.restful.service.tags.TagsService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/03/24 12:01
 * @description: TODO
 */
@Component
public class RecentBlogServiceImpl implements RecentBlogService {


    private final static QBlog Q_BLOG = QBlog.blog;

    private final static QTags Q_TAGS = QTags.tags;

    private final static QUser Q_USER = QUser.user;

    private final static Boolean IS_VISIBLE = true;

    private final static Boolean Not_Draft = false;

    @Autowired
    private TagsService tagsService;

    @Autowired
    private ImgService imgService;

    @Autowired
    private BlogImageService blogImageService;

    @Autowired
    private BlogCtegoryService blogCtegoryService;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public List<String> getBlogTags() {
        return tagsService.getBlogTags();
    }

    @Override
    public List<BlogResp> getRecentBlogList(BlogSearchReq blogSearchReq) {

        return JPAQueryWrapper.create(jpaQueryFactory.selectFrom(Q_BLOG))
            .where(Q_BLOG.isDraft.eq(Not_Draft))
            .where(Q_BLOG.isVisible.eq(IS_VISIBLE))
            .where(Objects.nonNull(blogSearchReq.getStartDate()), () -> Q_BLOG.createDate.goe(blogSearchReq.getStartDate()))
            .where(Objects.nonNull(blogSearchReq.getEndDate()), () -> Q_BLOG.createDate.loe(blogSearchReq.getEndDate()))
            .where(Objects.nonNull(blogSearchReq.getUserId()), () -> Q_BLOG.userId.eq(blogSearchReq.getUserId()))
            .where(!StringUtils.isEmpty(blogSearchReq.getCategoryName()), () -> Q_BLOG.category.eq(blogSearchReq.getCategoryName()))
            .where(!StringUtils.isEmpty(blogSearchReq.getTitle()), () -> Q_BLOG.title.like(blogSearchReq.getTitle()))
            .leftJoin(Q_TAGS)
            .on(Q_TAGS.blogId.eq(Q_BLOG.id))
            .where(!CollectionUtils.isEmpty(blogSearchReq.getTags()), () -> Q_TAGS.tagName.in(blogSearchReq.getTags()))
            .distinct()
            .orderBy(Q_BLOG.createDate.desc())
            .build()
            .fetchAll()
            .stream()
            .skip(blogSearchReq.getSkipBlogs())
            .limit(blogSearchReq.getPageLimit())
            .map(blog -> {
                Integer totalBlog = jpaQueryFactory.selectFrom(Q_BLOG)
                    .fetchAll()
                    .stream()
                    .collect(Collectors.toList())
                    .size();
                User user = getUserByUserId(blog.getUserId());
                Integer blogId = blog.getId();
                return BlogResp.build(blog, tagsService.getTagByBlogId(blogId), imgService.getImgByBlogId(blogId), user, totalBlog);
            })
            .collect(Collectors.toList());
    }

    private User getUserByUserId(Integer userId) {
        return jpaQueryFactory.selectFrom(Q_USER)
            .where(Q_USER.id.eq(userId))
            .fetchOne();
    }
}
