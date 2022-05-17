package com.school.education.service;

import com.school.education.domain.CourseTeacher;

import java.util.List;

public interface CourseTeacherService {
    List<CourseTeacher> selectCourse(Integer cat_id);
    List<CourseTeacher> selectCommand(Integer cs_hot);
    List<CourseTeacher> search(String condition);
    void updateSold(CourseTeacher courseTeacher);
    void updateLimit(CourseTeacher courseTeacher);
    CourseTeacher selectByCsId(Integer cs_id);
}
