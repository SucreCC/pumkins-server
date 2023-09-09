package com.pumkins.config.newsapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: Article
 */
@Data
@Accessors(chain = true)
public class Article {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
