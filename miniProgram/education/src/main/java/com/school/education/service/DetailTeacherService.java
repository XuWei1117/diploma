package com.school.education.service;

import com.school.education.domain.DetailTeacher;

public interface DetailTeacherService {
    DetailTeacher selectByCourseId(Integer cs_id);

}
