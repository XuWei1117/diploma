package com.school.education.controller;

import com.school.education.domain.Category;
import com.school.education.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/education/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/selectCategory")
    public @ResponseBody List<Category> selectCategory(){
        List<Category> categories = categoryService.selectCategory();
        return categories;
    }

}
