package com.school.management1.service;

import com.school.management1.domain.News;

import java.util.List;

public interface NewsService {
    List<News> selectAllNews(News news);
    Integer deleteNews(News news);
    Integer addNews(News news);
    News selectNewsById(Integer n_id);
    Integer updateNews(News news);
}
