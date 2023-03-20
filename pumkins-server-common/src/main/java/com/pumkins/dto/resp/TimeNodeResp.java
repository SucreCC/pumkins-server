package com.pumkins.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.dto.request.BlogLinkReq;
import com.pumkins.entity.TimeNode;
import com.pumkins.entity.TimeNodeLinkBlog;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/03/17 17:23
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class TimeNodeResp {
    private Integer id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;
    private String timeDescription;
    private Double latitude;
    private Double longitude;
    private List<TimeNodeLinkBlog> linkBlog;
    private List<String> tags;
    private String username;
    private Integer userId;

    public static TimeNodeResp build(TimeNode timeNode, List<String> timeNodeTags, List<TimeNodeLinkBlog> timeNodeLinkBlogs, TimeLineUserResp timeLineUserResp) {
        TimeNodeResp timeNodeResp = new TimeNodeResp();
        BeanUtils.copyProperties(timeNode, timeNodeResp);
        timeNodeResp.setUsername(timeLineUserResp.getUsername());
        return timeNodeResp.setLinkBlog(timeNodeLinkBlogs).setTags(timeNodeTags);
    }
}
