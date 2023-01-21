package com.pumkins.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.Blog;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2022/02/05 21:01
 * @description:
 */
@Data
@Accessors(chain = true)
public class BlogResp {

    private Integer id;
    private String title;
    private List<String> tags;
    private String markdown;
    private String blogDescription;
    private String username;
    private List<String> images;
    private Boolean isVisible;
    private String category;
    private Boolean workOrLife;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;
    private Integer numberOfThumbUp;
    private Integer numberOfView;
    private Integer numberOfComment;
    private Integer numberOfFavorite;
    private Boolean isDraft;

    public static BlogResp build(Blog blog, List<String> tags, List<String> images) {
        BlogResp blogResp = new BlogResp();
        BeanUtils.copyProperties(blog, blogResp);
        return blogResp.setTags(tags)
            .setImages(images);
    }
}
