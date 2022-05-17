package com.school.education.service.impl;

import com.school.education.domain.CourseTeacher;
import com.school.education.mapper.CourseTeacherMapper;
import com.school.education.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTeacherServiceImpl implements CourseTeacherService {
    @Autowired
    private CourseTeacherMapper mapper;
    @Override
    public List<CourseTeacher> selectCourse(Integer cat_id) {
        List<CourseTeacher> courses = mapper.selectCourse(cat_id);
        return courses;
    }
    @Override
    public List<CourseTeacher> selectCommand(Integer cs_hot) {
        List<CourseTeacher> courseTeachers = mapper.selectCommand(cs_hot);
        return courseTeachers;
    }
    @Override
    public List<CourseTeacher> search(String condition) {
        condition = "%" + condition + "%";
        List<CourseTeacher> search = mapper.search(condition);
        return search;
    }
    @Override
    public void updateSold(CourseTeacher courseTeacher) {
        mapper.updateSold(courseTeacher.getCs_id());
    }
    @Override
    public void updateLimit(CourseTeacher courseTeacher) {
        mapper.updateLimit(courseTeacher.getCs_id());
    }
    @Override
    public CourseTeacher selectByCsId(Integer cs_id) {
        CourseTeacher courseTeacher = mapper.selectByCsId(cs_id);
        return courseTeacher;
    }
}
