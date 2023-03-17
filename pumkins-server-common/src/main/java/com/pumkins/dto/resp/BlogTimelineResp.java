package com.pumkins.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.Blog;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/03/16 15:06
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class BlogTimelineResp {
    private Integer id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;

    public static BlogTimelineResp build (Blog blog){
        BlogTimelineResp blogTimelineResp = new BlogTimelineResp();
        BeanUtils.copyProperties(blog,blogTimelineResp);
        return blogTimelineResp;
    }
}
