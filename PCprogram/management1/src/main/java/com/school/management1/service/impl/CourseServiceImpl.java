package com.school.management1.service.impl;

import com.school.management1.domain.Course;
import com.school.management1.domain.vo.CourseDetailVO;
import com.school.management1.domain.vo.CourseVO;
import com.school.management1.mapper.CourseMapper;
import com.school.management1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseVO> courseMenu() {
        List<CourseVO> courseVOS = courseMapper.courseMenu();
        return courseVOS;
    }

    @Override
    public CourseDetailVO courseDetail(CourseDetailVO courseDetailVO) {
        CourseDetailVO courseDetail = courseMapper.courseDetail(courseDetailVO.getCs_id());
        return courseDetail;
    }

    @Override
    public Integer addCourse(CourseDetailVO courseDetailVO) {
        Integer count = courseMapper.addCourse(courseDetailVO);
        return count;
    }

    @Override
    public Integer updateCourse(CourseDetailVO courseDetailVO) {
        Integer count = courseMapper.updateCourse(courseDetailVO);
        return count;
    }

    @Override
    public Integer deleteCourse(Course course) {
        Integer count = courseMapper.deleteCourse(course.getCs_id());
        return count;
    }
}
