package com.pumkins.config.newsapi.client;


import com.pumkins.config.newsapi.dto.response.ArticleResponse;
import com.pumkins.config.newsapi.dto.response.SourcesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: APIService
 */

public interface APIService {
    @GET("/v2/sources")
    Call<SourcesResponse> getSources(@QueryMap Map<String, String> query);

    @GET("/v2/top-headlines")
    Call<ArticleResponse> getTopHeadlines(@QueryMap Map<String, String> query);

    @GET("/v2/everything")
    Call<ArticleResponse> getEverything( @QueryMap Map<String, String> query);
}

