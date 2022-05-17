package com.school.management1.mapper;

import com.school.management1.domain.Teacher;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<Teacher> showAllTeacher();
    List<Teacher> selectAllTeacher(@Param("t_name") String t_name);
    Integer addTeacher(Teacher teacher);
    Integer updateTeacher(Teacher teacher);
    Teacher selectTeacher(Integer t_id);
}
