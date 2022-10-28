package com.pumkins.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2022/02/05 21:01
 * @description:
 */
@Data
@Accessors(chain = true)
public class BlogReq {
    private Integer id;
    private String img;
    private String title;
    private String blogDescribe;
    private String content;
    private String createDate;
    private String updateDate;
}
