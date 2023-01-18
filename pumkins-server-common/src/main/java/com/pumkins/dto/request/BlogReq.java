package com.pumkins.dto.request;

import com.pumkins.entity.Blog;
import lombok.Data;
import lombok.experimental.Accessors;

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
    private String blogDescribe;
    private String username;
    private List<String> images;
    private Boolean isVisible;
    private String categoryId;
    private Boolean workOrLife;
    private Date createDate;
    private Date updateDate;
    private Integer numberOfThumbUp;
    private Integer numberOfView;
    private Integer numberOfComment;
    private Integer numberOfFavorite;
}
