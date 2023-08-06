package com.pumkins.restful.service.news;

import com.pumkins.dto.resp.NewsResp;
import com.pumkins.entity.News;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/08/06 20:20
 * @description: TODO
 */

public interface NewsService {
    void saveNews(List<News> newsList);

    List<NewsResp> getNews();
}
