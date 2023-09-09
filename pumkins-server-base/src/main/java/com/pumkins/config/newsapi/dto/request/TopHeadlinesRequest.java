package com.pumkins.config.newsapi.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: TopHeadlinesRequest
 */
@Data
@Accessors(chain = true)
public class TopHeadlinesRequest implements Requester {
    private String apiKey;
    private String country;
    private String sources;
    private String q;
    private String pageSize;
    private String page;
    private String language;
}
