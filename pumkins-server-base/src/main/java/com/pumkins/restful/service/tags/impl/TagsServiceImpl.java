package com.pumkins.restful.service.tags.impl;

import com.pumkins.entity.BlogTags;
import com.pumkins.entity.QTags;
import com.pumkins.entity.Tags;
import com.pumkins.repository.BlogTagsRepository;
import com.pumkins.repository.TagsRepository;
import com.pumkins.restful.service.tags.TagsService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: dengKai
 * @date: 2023/01/17 10:08
 * @description: TODO
 */
@Component
public class TagsServiceImpl implements TagsService {

    private final static QTags Q_TAGS = QTags.tags;

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private BlogTagsRepository blogTagsRepository;


    @Override
    public void checkDuplicateTag(List<String> tags) {

    }

    @Override
    public List<Integer> saveTags(List<String> tags) {

        ArrayList<Integer> tagList = new ArrayList<>();
        Date date = new Date();

        tags.forEach(tag -> {
            Tags tagByTagName = getTagByTagName(tag);
            if (Objects.nonNull(tagByTagName)){
                tagList.add(tagByTagName.getId());
                return;
            }

            Tags newTag = new Tags()
                .setCreateDate(date)
                .setUpdateDate(date)
                .setTagName(tag);
            Tags save = tagsRepository.save(newTag);
            tagList.add(save.getId());
        });

        return tagList;
    }

    @Override
    public void saveBatch(List<Integer> tags, Integer blogId) {
        Date date = new Date();
        tags.forEach(tagId->{
            BlogTags blogTags = new BlogTags()
                .setBlogId(blogId)
                .setTagId(tagId)
                .setCreateDate(date)
                .setUpdateDate(date);
            blogTagsRepository.save(blogTags);
        });
    }


    public Tags getTagByTagName(String tagName) {
        return jpaQueryFactory.selectFrom(Q_TAGS)
            .where(Q_TAGS.tagName.eq(tagName))
            .fetchOne();
    }
}
