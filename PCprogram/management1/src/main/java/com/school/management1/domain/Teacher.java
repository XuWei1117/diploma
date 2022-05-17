package com.school.management1.domain;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends PageInfo {
    private Integer t_id;//老师id
    private String t_name;//老师姓名
    private String t_nameNew;//老师姓名
    private String t_desc;
    private Integer t_gender;
    private Integer t_age;
    private String t_img;
}
