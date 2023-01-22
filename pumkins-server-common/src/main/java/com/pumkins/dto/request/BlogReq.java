package com.pumkins.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.Blog;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2022/02/05 21:01
 * @description:
 */
@Data
@Accessors(chain = true)
public class BlogReq {

    private Integer id;
    private String title;
    private List<String> tags;
    private String markdown;
    private String blogDescription;
    private String username;
    private List<Integer> images;
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

    public Blog convertToBlog() {
        Blog blog = new Blog();
        BeanUtils.copyProperties(this, blog);
        return blog;
    }
}
