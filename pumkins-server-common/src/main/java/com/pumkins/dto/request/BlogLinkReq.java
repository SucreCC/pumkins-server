package com.pumkins.dto.request;

import com.pumkins.entity.TimeNodeLinkBlog;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author: dengKai
 * @date: 2023/03/17 14:45
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class BlogLinkReq {
    private Integer id;
    private String title;
    private Integer timeNodeId;

    public TimeNodeLinkBlog convertToTimeNodeLinkBlog(TimeNodeReq timeNodeReq) {
        return new TimeNodeLinkBlog()
            .setBlogId(this.id)
            .setBlogTitle(this.title)
            .setTimeNodeId(timeNodeReq.getId())
            .setCreateDate(timeNodeReq.getCreateDate())
            .setUpdateDate(timeNodeReq.getUpdateDate());
    }
}
