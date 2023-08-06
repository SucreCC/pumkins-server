package com.pumkins.config.newsapi;

import com.pumkins.dto.request.NewsReq;
import com.pumkins.entity.News;
import com.pumkins.newsapi.NewsApiClient;
import com.pumkins.newsapi.callback.ArticlesResponseCallback;
import com.pumkins.newsapi.dto.Article;
import com.pumkins.newsapi.dto.request.EverythingRequest;
import com.pumkins.newsapi.dto.request.TopHeadlinesRequest;
import com.pumkins.newsapi.dto.response.ArticleResponse;
import com.pumkins.restful.service.news.NewsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/08/04 23:23
 * @description: TODO
 */
@Component
public class NewsUtils {
    @Resource
    private NewsService newsService;

    @Value("${newsApi.apiKey}")
    private String apiKey;

    /**
     * execute every 30 min
     */
    @Scheduled(cron = "0 */30 * * * ?")
    public void getNews() {
        try {
            getHeadLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getHeadLine() throws Exception {
        NewsApiClient newsApiClient = new NewsApiClient(apiKey);
        TopHeadlinesRequest topHeadlinesRequest = new TopHeadlinesRequest()
            .setCountry("us")
            .setPageSize("10")
            .setLanguage("en");
        newsApiClient.getTopHeadlines(
            topHeadlinesRequest,
            new ArticlesResponseCallback() {
                @Override
                public void onSuccess(ArticleResponse response) {
                    List<News> newsList = response.getArticles()
                        .stream()
                        .map(article -> new News()
                            .setTitle(article.getTitle())
                            .setUrl(article.getUrl()))
                        .collect(Collectors.toList());
                    if(!CollectionUtils.isEmpty(newsList)){
                        newsService.saveNews(newsList);
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            }
        );
    }


    private void getEverything() throws Exception {
        NewsApiClient newsApiClient = new NewsApiClient(apiKey);
        EverythingRequest everythingRequest = new EverythingRequest()
            .setLanguage("en")
            .setPageSize("10")
            .setSources("CNN");
        newsApiClient.getEverything(
            everythingRequest,
            new ArticlesResponseCallback() {
                @Override
                public void onSuccess(ArticleResponse response) {
                    for (Article article : response.getArticles()) {
                        System.out.println(article.getTitle());
                        System.out.println(article.getUrl());
                        System.out.println(article.getSource());
                    }
                    System.out.println(response.getArticles().get(0).getTitle());
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            }
        );
    }
}
