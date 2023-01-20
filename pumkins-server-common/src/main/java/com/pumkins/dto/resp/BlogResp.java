package com.pumkins.dto.resp;

import lombok.Data;
import lombok.experimental.Accessors;

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
    private Date createDate;
    private Date updateDate;
    private Integer numberOfThumbUp;
    private Integer numberOfView;
    private Integer numberOfComment;
    private Integer numberOfFavorite;
    private Boolean isDraft;
}
