package com.pumkins.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.BlogComment;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/01/22 10:58
 * @description: TODO
 */
@Data
@Accessors
public class BlogCommentResp {
    private Integer id;
    private Integer blogId;
    private Integer parentId;
    private String commentContent;
    private String username;
    private String icon;
    private Integer numberOfThumbUp;
    private List<BlogCommentResp> subComment;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;

    public static BlogCommentResp build(BlogComment blogComment){
        BlogCommentResp blogCommentResp = new BlogCommentResp();
        BeanUtils.copyProperties(blogComment,blogCommentResp);
        return blogCommentResp;
    }
}
