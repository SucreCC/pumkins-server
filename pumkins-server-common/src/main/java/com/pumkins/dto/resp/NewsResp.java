package com.pumkins.dto.resp;

import com.pumkins.entity.News;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * @author: dengKai
 * @date: 2023/08/06 20:32
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class NewsResp {
    private Integer id;
    private String title;
    private String url;

    public static NewsResp build(News news){
        NewsResp newsResp = new NewsResp();
        BeanUtils.copyProperties(news,newsResp);
        return newsResp;
    }
}
