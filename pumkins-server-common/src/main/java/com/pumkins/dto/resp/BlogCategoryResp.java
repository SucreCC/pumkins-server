package com.pumkins.dto.resp;

import com.pumkins.entity.BlogCategory;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Objects;

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

    public static BlogCategoryResp build(BlogCategory blogCategory){
        BlogCategoryResp blogCategoryResp = new BlogCategoryResp();
        if(Objects.isNull(blogCategory)){
            return blogCategoryResp;
        }
        BeanUtils.copyProperties(blogCategory,blogCategoryResp);
        return blogCategoryResp;
    }
}
