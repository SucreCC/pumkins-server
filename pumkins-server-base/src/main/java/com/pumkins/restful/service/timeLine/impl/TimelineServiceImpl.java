package com.pumkins.restful.service.timeLine.impl;

import com.pumkins.dto.request.BlogLinkReq;
import com.pumkins.dto.request.TimeNodeReq;
import com.pumkins.dto.resp.BlogTimelineResp;
import com.pumkins.entity.QBlog;
import com.pumkins.entity.TimeNode;
import com.pumkins.entity.TimeNodeLinkBlog;
import com.pumkins.entity.TimeNodeTags;
import com.pumkins.repository.TimeNodeLinkBlogRepository;
import com.pumkins.repository.TimeNodeRepository;
import com.pumkins.repository.TimeNodeTagsRepository;
import com.pumkins.restful.service.timeLine.TimelineService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/03/16 15:03
 * @description: TODO
 */
@Component
public class TimelineServiceImpl implements TimelineService {
    @Autowired
    private final static QBlog Q_BLOG = QBlog.blog;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private TimeNodeRepository timeNodeRepository;

    @Autowired
    private TimeNodeLinkBlogRepository timeNodeLinkBlogRepository;

    @Autowired
    private TimeNodeTagsRepository timeNodeTagsRepository;

    @Override
    public List<BlogTimelineResp> getBlogTimeList() {
        return jpaQueryFactory.selectFrom(Q_BLOG)
            .orderBy(Q_BLOG.createDate.desc())
            .fetchAll()
            .stream()
            .map(BlogTimelineResp::build)
            .collect(Collectors.toList());
    }

    @Override
    public void saveTimeNode(TimeNodeReq timeNodeReq) {
        System.out.println(timeNodeReq);
        System.out.println(timeNodeReq.convertToTimeNode());

        TimeNode timeNode = timeNodeRepository.save(timeNodeReq.convertToTimeNode());
        timeNodeReq.setId(timeNode.getId());
        saveLinkBlogs(timeNodeReq);
        saveTimeNodeTags(timeNodeReq);
    }

    private void saveLinkBlogs(TimeNodeReq timeNodeReq) {
        List<TimeNodeLinkBlog> linkBlogs = timeNodeReq.getLinkBlog().stream()
            .map(blogLinkReq -> blogLinkReq.convertToTimeNodeLinkBlog(timeNodeReq))
            .collect(Collectors.toList());
        timeNodeLinkBlogRepository.saveAll(linkBlogs);
    }

    private void saveTimeNodeTags(TimeNodeReq timeNodeReq) {
        List<TimeNodeTags> timeNodeTags = timeNodeReq.getTags().stream().map(tagName -> new TimeNodeTags()
            .setTimeNodeId(timeNodeReq.getId())
            .setTagName(tagName)
            .setCreateDate(timeNodeReq.getCreateDate())
            .setUpdateDate(timeNodeReq.getCreateDate())).collect(Collectors.toList());
        timeNodeTagsRepository.saveAll(timeNodeTags);
    }
}
