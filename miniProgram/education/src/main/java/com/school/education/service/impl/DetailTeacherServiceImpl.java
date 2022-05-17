package com.school.education.service.impl;

import com.school.education.domain.DetailTeacher;
import com.school.education.mapper.DetailTeacherMapper;
import com.school.education.service.DetailTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailTeacherServiceImpl implements DetailTeacherService {
    @Autowired
    private DetailTeacherMapper detailTeacherMapper;
    @Override
    public DetailTeacher selectByCourseId(Integer cs_id) {
        DetailTeacher detailTeacher = detailTeacherMapper.selectByCourseId(cs_id);
        return detailTeacher;

    }
}
