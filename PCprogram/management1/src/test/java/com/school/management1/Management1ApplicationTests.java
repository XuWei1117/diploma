package com.school.management1;


import com.school.management1.domain.*;
import com.school.management1.domain.vo.CourseDetailVO;
import com.school.management1.domain.vo.CourseVO;
import com.school.management1.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.PanelUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Management1Application.class})
public class Management1ApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Test
    public void  test(){
        List<User> users = userService.selectAllUser();
        System.out.println(users);
    }
    @Test
    public void  test2(){
        List<CourseVO> courseVOS = courseService.courseMenu();
        for (CourseVO courseVO : courseVOS) {
            System.out.println(courseVO);
        }
    }
    @Test
    public void test3(){
        CourseDetailVO courseDetail = new CourseDetailVO();
        courseDetail.setCs_name("语文诗歌鉴赏");
        courseDetail.setCs_price(110.99);
        courseDetail.setCs_desc("专注于诗歌鉴赏提升");
        courseDetail.setCs_time("10课时");
        courseDetail.setCat_id(1);
        courseDetail.setTe_id(26);
        courseDetail.setLimit_buy(100);
        courseDetail.setSold(90);
        Integer count = courseService.addCourse(courseDetail);
        System.out.println(count);
    }

    @Test
    public void test4(){
        CourseDetailVO courseDetail = new CourseDetailVO();
        courseDetail.setCs_id(1);
        CourseDetailVO courseDetailVO = courseService.courseDetail(courseDetail);

        System.out.println(courseDetailVO);
    }

    @Autowired
    private NewsService newsService;
    @Test
    public void test5(){
        News news = new News();
        news.setPageNum(1);
        news.setPageSize(10);
        news.setCondition("共产");
        List<News> news1 = newsService.selectAllNews(news);

        System.out.println(news1);
    }

    @Test
    public void test6(){
        News news = new News();
       news.setN_title("fcdvc");
       news.setN_detail1("fwedafgvsrd");
       //news.setN_date("2022-05-05 16:56:10");
        Integer count = newsService.addNews(news);

        System.out.println(count);
    }

    @Test
    public void test7(){
        News news = new News();
        news.setN_id(12);
        news.setN_title("fcdvc");
        news.setN_detail1("fwedafgvsrd");
        news.setN_date_str("2022-05-05 16:56:10");
        Integer count = newsService.updateNews(news);

        System.out.println(count);
    }
}
