package com.pumkins.dto.request;

import com.pumkins.entity.BlogCategory;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/01/16 20:19
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class BlogCategoryReq {

    private Integer id;
    private String label;
    private Integer value;
    private Date createDate;
    private Date updateDate;

    public BlogCategory convertToBlogCategory(){
        BlogCategory blogCategory = new BlogCategory();
        BeanUtils.copyProperties(this,blogCategory);
        return blogCategory;
    }
}
