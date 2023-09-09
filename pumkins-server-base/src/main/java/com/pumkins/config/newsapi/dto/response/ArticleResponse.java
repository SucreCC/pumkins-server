package com.pumkins.config.newsapi.dto.response;

import com.pumkins.config.newsapi.dto.Article;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: ArticleResponse
 */
@Data
@Accessors(chain = true)
public class ArticleResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;
}
