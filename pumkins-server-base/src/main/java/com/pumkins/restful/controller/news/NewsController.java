package com.pumkins.restful.controller.news;

import com.pumkins.dto.resp.NewsResp;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.news.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/08/06 20:19
 * @description: TODO
 */
@RestController
@RequestMapping("/pumkins/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    @GetMapping("/get-hot-topic")
    private JsonResp<List<NewsResp>> getHotTopic(){
        List<NewsResp> news = newsService.getNews();
        return JsonResp.success(news);
    }
}
