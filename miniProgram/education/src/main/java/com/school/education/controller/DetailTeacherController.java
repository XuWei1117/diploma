package com.school.education.controller;

import com.school.education.domain.DetailTeacher;
import com.school.education.service.DetailTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/education/detail")
@Controller
public class DetailTeacherController {
    @Autowired
    private DetailTeacherService service;

    /**
     * 前一个页面传过来courseid，通过courseid查询课程详情和老师
     * @param cs_id
     * @return
     */
    @RequestMapping("/selectByCourseId")
    public @ResponseBody DetailTeacher selectByCourseId(Integer cs_id){
        DetailTeacher detailTeacher = service.selectByCourseId(cs_id);
        return detailTeacher;
    }
}
