package com.pumkins.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pumkins.entity.Blog;
import com.pumkins.util.DateUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/08/09 16:44
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class FeaturedArticleResp {
    private Integer id;
    private String title;
    private List<String> images;
    private String day;
    private String blogDescription;


    public static FeaturedArticleResp buildFeaturedArticle(Blog blog, List<String> images) {
        FeaturedArticleResp featuredArticleResp = new FeaturedArticleResp();
        BeanUtils.copyProperties(blog, featuredArticleResp);
        featuredArticleResp.setImages(images)
            .setDay(DateUtils.getDay(blog.getCreateDate()));
        return featuredArticleResp;
    }


}
