package com.school.management1.mapper;

import com.school.management1.domain.News;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<News> selectAllNews(@Param("news") News news);
    Integer deleteNews(Integer n_id);
    Integer addNews(News news);
    News selectNewsById(Integer n_id);
    Integer updateNews(News news);
}
