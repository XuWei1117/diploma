package com.school.management1.controller;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.management1.domain.News;
import com.school.management1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/management/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/getAllNews")
    public PageInfo<News> getAllNews(@RequestBody News news){
        if (null == news || null == String.valueOf(news.getPageNum())) {
            news.setPageNum(1);
        }
        if (null == news || null == String.valueOf(news.getPageSize())) {
            news.setPageSize(10);
        }
        PageHelper.startPage(news.getPageNum(), news.getPageSize());
        List<News> news1 = newsService.selectAllNews(news);
        PageInfo<News> pageInfo = new PageInfo<>(news1);
        return pageInfo;
    }

    @RequestMapping("/deleteNews")
    public HashMap<String,Object> deleteNews(@RequestBody News news){
        Integer count = newsService.deleteNews(news);
        HashMap<String, Object> map = new HashMap<>();
        if (count == 1){
            map.put("code","200");
            map.put("msg","删除成功");
        }
        return map;
    }
    @RequestMapping("/addNews")
    public HashMap<String,Object> addNews(@RequestBody News news){
        System.out.println("news = " + news);
        news.setN_date(DateUtil.parse(news.getN_date_str()));
        Integer count = newsService.addNews(news);
        HashMap<String, Object> map = new HashMap<>();
        if (count == 1){
            map.put("code","200");
            map.put("msg","新增成功");
        }
        return map;
    }
    @RequestMapping("/selectNewsById")
    public News selectNewsById(@RequestBody News news){
        News news1 = newsService.selectNewsById(news.getN_id());
        return news1;
    }
    @RequestMapping("/updateNews")
    public HashMap<String,String> updateNews(@RequestBody News news){
        news.setN_date(DateUtil.parse(news.getN_date_str()));
        Integer count = newsService.updateNews(news);
        HashMap<String, String> map = new HashMap<>();
        if(count == 1){
            map.put("code","200");
            map.put("msg","修改成功");
        }
        return map;
    }
}
