package com.school.education.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseTeacher {
    /*
    * private Integer cs_id;课程id
    private String cs_name;课程名称
    private double cs_price;课程价格
    private String cs_img;课程详情里面的图片
    private String cs_desc;课程描述
    private String cs_time;课时
    private Integer cat_id;所属的一级分类
    private Integer t_id;老师id
    private Integer cs_hot;是否在推荐课程内
    * */
    private Integer cs_id;
    private String cs_name;
    private double cs_price;
    private String cs_img;
    private String cs_desc;
    private String cs_time;
    private Integer cat_id;
    private Integer te_id;
    private Integer cs_hot;
    private Integer limit_buy;//限售
    private Integer sold;//已售
    private String order_img;
    private String video;

    private Integer t_id;//教师id
    private String t_name;//教师名称
    private String t_desc;//教师描述
    private String t_img;//教师头像



}
