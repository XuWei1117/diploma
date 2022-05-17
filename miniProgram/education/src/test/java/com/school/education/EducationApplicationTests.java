package com.school.education;


import com.school.education.domain.*;
import com.school.education.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EducationApplicationTests {
    @Autowired
    private SwiperService service;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CourseTeacherService courseTeacherService;

    @Test
   public void contextLoads() {
        List<Swiper> swipers = service.selectSwiper();
        swipers.forEach((item) -> {
            System.out.println("item = " + item);
        });
    }

    @Test
    public void function1(){
        List<Category> categories = categoryService.selectCategory();
        categories.forEach(category -> {
            System.out.println(category);
        });
    }

    @Test
    public void function2(){
        List<CourseTeacher> courseTeachers = courseTeacherService.selectCourse(1);
        courseTeachers.forEach(course ->{
            System.out.println(course);
        });
    }

    @Test
    public void function3(){
        List<CourseTeacher> courseTeachers = courseTeacherService.selectCommand(1);
        courseTeachers.forEach((course) ->{
            System.out.println(course);
        });
    }

    @Test
    public void function4(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
        String format = sdf.format(new Date());
        System.out.println(format);
    }

    @Autowired
    private CommentService commentService;
    @Test
    public void function5(){
        List<Comment> comments = commentService.selectCommentByCourseId(1);
        comments.forEach((comment) -> {
            System.out.println(comment);
        });

    }

    @Autowired
    private UserService userService;

    @Test
    public void function6(){
        Date date = new Date();
        User user = new User();
        //null,"Fighting",0,date,"山东"
        user.setU_name("Fighting");
        user.setU_gender(1);
        user.setU_newLogin(date);
        Integer count = userService.login(user);
        System.out.println(count);
    }

    @Autowired
    private DetailTeacherService detailTeacherService;

    @Autowired
    private CommentService commentService1;

    @Test
    public void function7(){
        DetailTeacher detailTeacher = detailTeacherService.selectByCourseId(1);
        List<Comment> comments = commentService1.selectCommentByCourseId(1);
        System.out.println(detailTeacher);
        System.out.println("comments = " + comments);
    }

}
