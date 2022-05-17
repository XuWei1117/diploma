package com.school.education.controller;

import com.school.education.domain.News;
import com.school.education.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/education/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     *
     * @return
     */
    //http://localhost:8081/education/news/selectAllNews
    @RequestMapping("/selectAllNews")
    public List<News> selectAllNews(){
        List<News> news = newsService.selectAllNews();
        return news;
    }
    @RequestMapping("/selectNewsDetail")
    public News selectNewsDetail(@RequestParam("n_id") Integer n_id){
        News news1 = newsService.selectNewsDetail(n_id);
        return news1;
    }


}
