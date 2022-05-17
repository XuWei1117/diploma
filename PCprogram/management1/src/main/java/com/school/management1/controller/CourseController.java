package com.school.management1.controller;

import com.school.management1.domain.Course;
import com.school.management1.domain.vo.CourseDetailVO;
import com.school.management1.domain.vo.CourseVO;
import com.school.management1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/management/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/showCourseList")
    public HashMap<String,Object> showCourseList(){
        List<CourseVO> courseVOS = courseService.courseMenu();
        HashMap<String, Object> map = new HashMap<>();
        map.put("courseList",courseVOS);
        return map;
    }
    @RequestMapping("/courseDetail")
    public CourseDetailVO courseDetail(@RequestBody CourseDetailVO courseDetail){
        CourseDetailVO courseDetailVO = courseService.courseDetail(courseDetail);
        return courseDetailVO;
    }
    @RequestMapping("/addCourse")
    public HashMap<String,Object> addCourse(@RequestBody CourseDetailVO courseDetailVO){
        courseDetailVO.setCs_img("https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/addCourse.png");
        courseDetailVO.setOrder_img("https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/order.jpg");
        courseDetailVO.setVideo("https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4");
        Integer count = courseService.addCourse(courseDetailVO);
        HashMap<String, Object> map = new HashMap<>();
        if(count == 1){
            map.put("msg","新增课程成功");
            map.put("code","200");
        }
        return map;
    }
    @RequestMapping("/updateCourse")
    public HashMap<String,Object> updateCourse(@RequestBody CourseDetailVO courseDetailVO){
        Integer count = courseService.updateCourse(courseDetailVO);
        HashMap<String, Object> map = new HashMap<>();
        if(count == 1){
            map.put("msg","修改课程成功");
            map.put("code","200");
        }
        return map;
    }
    @RequestMapping("/deleteCourse")
    public HashMap<String,Object> deleteCourse(@RequestBody Course course){
        Integer count = courseService.deleteCourse(course);
        HashMap<String, Object> map = new HashMap<>();
        if(count == 1){
            map.put("msg","删除课程成功");
            map.put("code","200");
        }
        return map;
    }


}
