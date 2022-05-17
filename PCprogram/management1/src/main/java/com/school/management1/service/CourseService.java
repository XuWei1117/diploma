package com.school.management1.service;

import com.school.management1.domain.Course;
import com.school.management1.domain.vo.CourseDetailVO;
import com.school.management1.domain.vo.CourseVO;

import java.util.List;

public interface CourseService{
    List<CourseVO> courseMenu();
    CourseDetailVO courseDetail(CourseDetailVO courseDetail);
    Integer addCourse(CourseDetailVO courseDetailVO);
    Integer updateCourse(CourseDetailVO courseDetailVO);
    Integer deleteCourse(Course course);
}
