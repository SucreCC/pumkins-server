package com.pumkins.restful.service.news.impl;

import com.pumkins.dto.resp.NewsResp;
import com.pumkins.entity.News;
import com.pumkins.entity.QNews;
import com.pumkins.repository.NewsRepository;
import com.pumkins.restful.service.news.NewsService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2023/08/06 20:21
 * @description: TODO
 */
@Service
public class NewServiceImpl implements NewsService {
    private static final QNews NEWS = QNews.news;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private NewsRepository newsRepository;


    @Override
    public void saveNews(List<News> newsList) {
        newsRepository.deleteAll();
        newsRepository.saveAll(newsList);
    }

    @Override
    public List<NewsResp> getNews() {
        return jpaQueryFactory.selectFrom(NEWS)
            .fetchAll()
            .stream()
            .map(NewsResp::build)
            .collect(Collectors.toList());
    }
}
