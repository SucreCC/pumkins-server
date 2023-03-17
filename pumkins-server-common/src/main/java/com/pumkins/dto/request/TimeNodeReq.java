package com.pumkins.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.TimeNode;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/03/17 14:39
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class TimeNodeReq {
    private Integer id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;
    private String timeDescription;
    private Double latitude;
    private Double longitude;
    private List<BlogLinkReq> linkBlog;
    private List<String> tags;
    private String username;
    private Integer userId;

    public TimeNode convertToTimeNode(){
        TimeNode timeNode = new TimeNode();
        BeanUtils.copyProperties(this,timeNode);
        return timeNode;
    }
}
