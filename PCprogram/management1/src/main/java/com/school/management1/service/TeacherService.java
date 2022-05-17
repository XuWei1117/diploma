package com.school.management1.service;

import com.school.management1.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> showAllTeacher();
    Integer addTeacher(Teacher teacher);
    Integer updateTeacher(Teacher teacher);
    Teacher selectTeacher(Integer t_id);
    List<Teacher> selectAllTeacher(Teacher teacher);
}
