package com.school.management1.service.impl;

import com.school.management1.domain.Teacher;
import com.school.management1.mapper.TeacherMapper;
import com.school.management1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public List<Teacher> showAllTeacher() {
        List<Teacher> teachers = teacherMapper.showAllTeacher();
        return teachers;
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        Integer count = teacherMapper.addTeacher(teacher);
        return count;
    }

    @Override
    public Integer updateTeacher(Teacher teacher) {
        Integer count = teacherMapper.updateTeacher(teacher);
        return count;
    }

    @Override
    public Teacher selectTeacher(Integer t_id) {
        Teacher teacher = teacherMapper.selectTeacher(t_id);
        return teacher;
    }

    @Override
    public List<Teacher> selectAllTeacher(Teacher teacher) {
        List<Teacher> teachers = teacherMapper.selectAllTeacher(teacher.getT_name());
        return teachers;
    }
}
