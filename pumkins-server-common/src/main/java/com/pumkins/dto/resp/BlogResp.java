package com.pumkins.dto.resp;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

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
    private String tags;
    private String markdown;
    private String blogDescribe;
    private String username;
    private String images;
    private Boolean isVisible;
    private String categoryIid;
    private Boolean workOrLife;
    private Date createDate;
    private Date updateDate;
    private Integer numberOfThumbUp;
    private Integer numberOfView;
    private Integer numberOfComment;
    private Integer numberOfFavorite;
}
