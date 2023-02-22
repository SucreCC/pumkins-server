package com.pumkins.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.BlogComment;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/01/22 10:58
 * @description: TODO
 */
@Data
@Accessors
public class BlogCommentReq {
    private Integer id;
    private Integer blogId;
    private Integer parentId;
    private String commentContent;
    private String username;
    private String icon;
    private Integer numberOfThumbUp;
    private Date createDate;
    private Date updateDate;

    public BlogComment build(){
        BlogComment blogComment = new BlogComment();
        BeanUtils.copyProperties(this,blogComment);
        Date date = new Date();
        blogComment.setCreateDate(date);
        blogComment.setUpdateDate(date);
        return blogComment;
    }
}
