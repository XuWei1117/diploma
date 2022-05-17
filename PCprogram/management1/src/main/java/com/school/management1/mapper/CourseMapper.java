package com.school.management1.mapper;

import com.school.management1.domain.vo.CourseDetailVO;
import com.school.management1.domain.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<CourseVO> courseMenu();
    CourseDetailVO courseDetail(Integer cs_id);
    Integer addCourse(CourseDetailVO courseDetailVO);
    Integer updateCourse(CourseDetailVO courseDetailVO);
    Integer deleteCourse(Integer cs_id);
}
