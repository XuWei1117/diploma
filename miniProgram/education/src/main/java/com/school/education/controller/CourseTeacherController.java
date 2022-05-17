package com.school.education.controller;

import com.school.education.domain.CourseTeacher;
import com.school.education.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/education/course")
public class CourseTeacherController {
    @Autowired
    private CourseTeacherService service;

    /**
     * 根据分类id查询该分类下面的所有课程
     * @param c_id
     * @return
     */
    @RequestMapping("/selectCourse")
    public @ResponseBody
    List<CourseTeacher> selectAllCourse(Integer c_id){
        List<CourseTeacher> courses = service.selectCourse(c_id);
        return courses;
    }

    /**
     * 模糊查询想要的课程
     * 在搜索框中搜索课程或者老师的名字
     */
    @RequestMapping("/search")
    public @ResponseBody List<CourseTeacher> search(String condition){
        List<CourseTeacher> search = service.search(condition);
        return search;
    }

    @RequestMapping("/getHot")
    public @ResponseBody List<CourseTeacher> getHot(){
        List<CourseTeacher> search = service.selectCommand(1);
        return search;
    }

}
