package com.school.education.mapper;

import com.school.education.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectCategory();

}
