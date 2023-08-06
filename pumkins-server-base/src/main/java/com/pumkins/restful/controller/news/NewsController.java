package com.pumkins.restful.controller.news;

import com.pumkins.restful.service.news.NewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dengKai
 * @date: 2023/08/06 20:19
 * @description: TODO
 */
@RestController
@RequestMapping("/pumkins")
public class NewsController {
    @Resource
    private NewsService newsService;
}
