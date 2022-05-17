package com.school.education.service.impl;

import com.school.education.domain.News;
import com.school.education.mapper.NewsMapper;
import com.school.education.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<News> selectAllNews() {
        return newsMapper.selectAllNews();
    }

    @Override
    public News selectNewsDetail(Integer n_id) {
        News news = newsMapper.selectNewsDetail(n_id);
        return news;
    }
}
