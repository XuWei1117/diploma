package com.school.management1.service.impl;

import com.school.management1.domain.News;
import com.school.management1.mapper.NewsMapper;
import com.school.management1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<News> selectAllNews(News news) {
        news.setConditionNew("%" + news.getCondition() + "%");
        List<News> news1 = newsMapper.selectAllNews(news);
        return news1;
    }

    @Override
    public Integer deleteNews(News news) {
        Integer count = newsMapper.deleteNews(news.getN_id());
        return count;
    }

    @Override
    public Integer addNews(News news) {
        Integer count = newsMapper.addNews(news);
        return count;
    }

    @Override
    public News selectNewsById(Integer n_id) {
        News news = newsMapper.selectNewsById(n_id);
        return news;
    }

    @Override
    public Integer updateNews(News news) {
        Integer count = newsMapper.updateNews(news);
        return count;
    }
}
