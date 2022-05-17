package com.school.education.mapper;

import com.school.education.domain.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseTeacherMapper {
    List<CourseTeacher> selectCourse(Integer cat_id);
    List<CourseTeacher> selectCommand(Integer cs_hot);
    List<CourseTeacher> search(String condition);
    void updateSold(Integer cs_id);
    void updateLimit(Integer cs_id);
    CourseTeacher selectByCsId(Integer cs_id);
    List<CourseTeacher> getHot();
}
