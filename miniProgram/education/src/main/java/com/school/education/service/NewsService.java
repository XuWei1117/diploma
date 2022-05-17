package com.school.education.service;

import com.school.education.domain.News;

import java.util.List;

public interface NewsService {
    List<News> selectAllNews();
    News selectNewsDetail(Integer n_id);
}
