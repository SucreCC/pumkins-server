package com.pumkins.restful.service.blog.impl;

import com.pumkins.restful.service.blog.RecentBlogService;
import com.pumkins.restful.service.tags.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/03/24 12:01
 * @description: TODO
 */
@Component
public class RecentBlogServiceImpl implements RecentBlogService {

    @Autowired
    private TagsService tagsService;

    @Override
    public List<String> getBlogTags() {
        return tagsService.getBlogTags();
    }
}
