package com.pumkins.config.newsapi.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: APIService
 */

public class APIClient {
    private static Retrofit mRetrofit = null;

    private static Retrofit getRetrofit(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    public static APIService getAPIService(){
        return getRetrofit().create(APIService.class);
    }

}

