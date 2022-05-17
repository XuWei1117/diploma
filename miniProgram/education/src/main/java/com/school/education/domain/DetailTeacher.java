package com.school.education.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 用于点击某个课程，显示该课程的详细细信息
* 需要的字段
* cs_id 课程id
* cs_name 课程名称
* cs_price 课程的价格
* cs_img 课程图片
* cs_desc 课程描述
* cs_time 课时
*
* 需要老师表中的字段
* t_id 老师的id
* t_name 老师的名称
* t_desc 老师的描述
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailTeacher {
    private Integer cs_id;
    private String cs_name;
    private double cs_price;
    private String cs_img;
    private String cs_desc;
    private String cs_time;
    private Integer t_id;
    private String t_name;
    private String t_desc;
    private String t_img;
    private String order_img;

}
