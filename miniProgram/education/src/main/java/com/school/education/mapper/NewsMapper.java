package com.school.education.mapper;

import com.school.education.domain.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NewsMapper {
    List<News> selectAllNews();
    News selectNewsDetail(Integer n_id);


}
