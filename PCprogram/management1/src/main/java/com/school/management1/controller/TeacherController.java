package com.school.management1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.management1.domain.Teacher;
import com.school.management1.domain.vo.OrderVO;
import com.school.management1.service.TeacherService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/management/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacherOption")
    public List<Teacher> showAllTeacher(){
        List<Teacher> teachers = teacherService.showAllTeacher();
        return teachers;
    }
    @RequestMapping("/selectAllTeacher")
    public PageInfo<Teacher> selectAllTeacher(@RequestBody Teacher teacher){
        if (null == teacher || null == String.valueOf(teacher.getPageNum())) {
            teacher.setPageNum(1);
        }
        if (null == teacher || null == String.valueOf(teacher.getPageSize())) {
            teacher.setPageSize(10);
        }
        PageHelper.startPage(teacher.getPageNum(), teacher.getPageSize());
        if(teacher.getT_name() != null){
            teacher.setT_name("%" + teacher.getT_name() + "%");
        }
        List<Teacher> teachers = teacherService.selectAllTeacher(teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        return pageInfo;
    }
    @RequestMapping("/addTeacher")
    public HashMap<String,Object> addTeacher(@RequestBody Teacher teacher){
        Integer count = teacherService.addTeacher(teacher);
        HashMap<String, Object> map = new HashMap<>();
        if(teacher.getT_gender() == 1){//女
            teacher.setT_img("https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg");
        }
        if(teacher.getT_gender() == 0){
            teacher.setT_img("https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg");
        }
        if(count == 1){
            map.put("msg","新增教师成功");
            map.put("code","200");
        }
        return map;
    }

    @RequestMapping("/selectTeacher")
    public Teacher selectTeacher(@RequestBody Teacher teacher){
        Teacher teacher1 = teacherService.selectTeacher(teacher.getT_id());
        return teacher1;
    }
    @RequestMapping("/updateTeacher")
    public HashMap<String,Object> updateTeacher(@RequestBody Teacher teacher){
        Integer count = teacherService.updateTeacher(teacher);
        HashMap<String, Object> map = new HashMap<>();
        if(count == 1){
            map.put("msg","修改教师信息成功");
            map.put("code","200");
        }
        return map;
    }

}
