package com.school.education.service.impl;

import com.school.education.domain.Category;
import com.school.education.mapper.CategoryMapper;
import com.school.education.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectCategory() {
        List<Category> categories = categoryMapper.selectCategory();
        return categories;
    }
}
