package com.pumkins.restful.service.timeLine.impl;

import com.pumkins.dto.request.TimeLineSearchReq;
import com.pumkins.dto.request.TimeNodeReq;
import com.pumkins.dto.resp.BlogTimelineResp;
import com.pumkins.dto.resp.TimeLineUserResp;
import com.pumkins.dto.resp.TimeNodeResp;
import com.pumkins.entity.QBlog;
import com.pumkins.entity.QTimeNode;
import com.pumkins.entity.QTimeNodeLinkBlog;
import com.pumkins.entity.QTimeNodeTags;
import com.pumkins.entity.TimeNode;
import com.pumkins.entity.TimeNodeLinkBlog;
import com.pumkins.entity.TimeNodeTags;
import com.pumkins.querydsl.JPAQueryWrapper;
import com.pumkins.repository.TimeNodeLinkBlogRepository;
import com.pumkins.repository.TimeNodeRepository;
import com.pumkins.repository.TimeNodeTagsRepository;
import com.pumkins.restful.service.timeLine.TimelineService;
import com.pumkins.restful.service.user.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/03/16 15:03
 * @description: TODO
 */
@Component
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    private final static Integer SELECT_LIMIT = 10;

    @Autowired
    private final static QBlog Q_BLOG = QBlog.blog;

    @Autowired
    private final static QTimeNodeTags Q_TIME_NODE_TAGS = QTimeNodeTags.timeNodeTags;

    @Autowired
    private final static QTimeNodeLinkBlog Q_TIME_NODE_LINK_BLOG = QTimeNodeLinkBlog.timeNodeLinkBlog;

    @Autowired
    private final static QTimeNode Q_TIME_NODE = QTimeNode.timeNode;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private TimeNodeRepository timeNodeRepository;

    @Autowired
    private TimeNodeLinkBlogRepository timeNodeLinkBlogRepository;

    @Autowired
    private TimeNodeTagsRepository timeNodeTagsRepository;

    @Autowired
    private UserService userService;

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
        TimeNode timeNode = timeNodeRepository.save(timeNodeReq.convertToTimeNode());
        timeNodeReq.setId(timeNode.getId());
        if (!CollectionUtils.isEmpty(timeNodeReq.getLinkBlog())) {
            saveLinkBlogs(timeNodeReq);
        }

        if (!CollectionUtils.isEmpty(timeNodeReq.getTags())) {
            saveTimeNodeTags(timeNodeReq);
        }
    }

    @Override
    public List<TimeNodeResp> getBlogTimeNodes() {
        return jpaQueryFactory.selectFrom(Q_TIME_NODE)
            .fetchAll()
            .limit(SELECT_LIMIT)
//            .orderBy(Q_TIME_NODE.id.desc(), Q_TIME_NODE.createDate.desc())
            .orderBy(Q_TIME_NODE.createDate.desc(),Q_TIME_NODE.id.desc())
            .stream()
            .map(timeNode -> {
                List<String> timeNodeTags = jpaQueryFactory.selectFrom(Q_TIME_NODE_TAGS)
                    .where(Q_TIME_NODE_TAGS.timeNodeId.eq(timeNode.getId()))
                    .fetchAll()
                    .stream()
                    .map(TimeNodeTags::getTagName)
                    .collect(Collectors.toList());

                List<TimeNodeLinkBlog> timeNodeLinkBlogs = jpaQueryFactory.selectFrom(Q_TIME_NODE_LINK_BLOG)
                    .where(Q_TIME_NODE_LINK_BLOG.timeNodeId.eq(timeNode.getId()))
                    .fetchAll()
                    .stream()
                    .collect(Collectors.toList());
                TimeLineUserResp timeLineUserResp = userService.getTimeLineUserById(timeNode.getUserId());
                return TimeNodeResp.build(timeNode, timeNodeTags, timeNodeLinkBlogs, timeLineUserResp);

            })
            .collect(Collectors.toList());
    }

    @Override
    public List<TimeLineUserResp> getTimeLineUserList() {
        return userService.getTimeLineUserList();
    }

    @Override
    public List<String> getTagList() {
        return jpaQueryFactory.selectFrom(Q_TIME_NODE_TAGS)
            .orderBy(Q_TIME_NODE_TAGS.createDate.desc())
            .stream()
            .distinct()
            .map(TimeNodeTags::getTagName)
            .collect(Collectors.toList());
    }

    @Override
    public List<TimeNodeResp> searchNodeList(TimeLineSearchReq timeLineSearchReq) {
        return JPAQueryWrapper.create(jpaQueryFactory.selectFrom(Q_TIME_NODE))
            .where(Objects.nonNull(timeLineSearchReq.getUserId()), () -> Q_TIME_NODE.userId.eq(timeLineSearchReq.getUserId()))
            .where(Objects.nonNull(timeLineSearchReq.getStartDate()), () -> Q_TIME_NODE.createDate.goe(timeLineSearchReq.getStartDate()))
            .where(Objects.nonNull(timeLineSearchReq.getEndDate()), () -> Q_TIME_NODE.createDate.loe(timeLineSearchReq.getEndDate()))
            .leftJoin(Q_TIME_NODE_TAGS)
            .on(Q_TIME_NODE_TAGS.timeNodeId.eq(Q_TIME_NODE.id))
            .where(!CollectionUtils.isEmpty(timeLineSearchReq.getTags()), () -> Q_TIME_NODE_TAGS.tagName.in(timeLineSearchReq.getTags()))
            .distinct()
            .orderBy(Q_TIME_NODE.createDate.desc())
            .build()
            .fetchAll()
            .stream()
            .map(timeNode -> {
                List<TimeNodeLinkBlog> timeNodeLinkBlogList = jpaQueryFactory.selectFrom(Q_TIME_NODE_LINK_BLOG)
                    .where(Q_TIME_NODE_LINK_BLOG.timeNodeId.eq(timeNode.getId()))
                    .fetchAll()
                    .stream()
                    .collect(Collectors.toList());

                List<String> timeNodeTags = jpaQueryFactory.selectFrom(Q_TIME_NODE_TAGS)
                    .fetchAll()
                    .stream()
                    .map(TimeNodeTags::getTagName)
                    .collect(Collectors.toList());
                TimeLineUserResp timeLineUserResp = userService.getTimeLineUserById(timeNode.getUserId());
                return TimeNodeResp.build(timeNode, timeNodeTags, timeNodeLinkBlogList, timeLineUserResp);
            })
            .collect(Collectors.toList());
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
