package com.pumkins.dto.resp;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/01/16 20:19
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class BlogCategoryResp {

    private Integer id;
    private String label;
    private Integer value;
    private Date createDate;
    private Date updateDate;
}
