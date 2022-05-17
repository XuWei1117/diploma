package com.school.education.mapper;

import com.school.education.domain.DetailTeacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailTeacherMapper {
    DetailTeacher selectByCourseId(Integer cs_id);
}
