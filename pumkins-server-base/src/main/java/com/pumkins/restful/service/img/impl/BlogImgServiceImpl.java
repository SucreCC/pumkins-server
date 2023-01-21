package com.pumkins.restful.service.img.impl;

import com.pumkins.entity.BlogImg;
import com.pumkins.entity.QBlogImg;
import com.pumkins.repository.BlogImagRepository;
import com.pumkins.restful.service.img.BlogImageService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/01/20 14:38
 * @description: TODO
 */
@Component
public class BlogImgServiceImpl implements BlogImageService {
    private final static QBlogImg Q_BLOG_IMG = QBlogImg.blogImg;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private BlogImagRepository blogImagRepository;

    @Override
    public void saveBatch(List<Integer> images, Integer blogId) {

        Date date = new Date();
        images.forEach(imgId -> {
            BlogImg blogImgFromDB = jpaQueryFactory.selectFrom(Q_BLOG_IMG)
                .where(Q_BLOG_IMG.blogId.eq(blogId))
                .where(Q_BLOG_IMG.imgId.eq(imgId))
                .fetchOne();

            if (blogImgFromDB == null) {
                BlogImg blogImg = new BlogImg()
                    .setImgId(imgId)
                    .setBlogId(blogId)
                    .setCreateDate(date)
                    .setUpdateDate(date);
                blogImagRepository.save(blogImg);
            }
        });
    }

    @Override
    public List<Integer> getImgByBlogId(Integer blogId) {
        return jpaQueryFactory.selectFrom(Q_BLOG_IMG)
            .where(Q_BLOG_IMG.blogId.eq(blogId))
            .fetchAll()
            .stream()
            .map(BlogImg::getImgId)
            .collect(Collectors.toList());
    }

    @Override
    public void saveEditBlogImages(List<Integer> images, Integer blogId) {
        Integer id = Objects.requireNonNull(jpaQueryFactory.selectFrom(Q_BLOG_IMG)
                .where(Q_BLOG_IMG.blogId.eq(blogId))
                .fetchOne())
            .getId();
        blogImagRepository.deleteById(id);
        saveBatch(images, blogId);
    }
}
