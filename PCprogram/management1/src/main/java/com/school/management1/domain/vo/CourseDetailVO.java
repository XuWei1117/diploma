package com.school.management1.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetailVO {
    private Integer cs_id;//课程id
    private String cs_name;//课程名称
    private Double cs_price;//课程价格
    private String cs_desc;//课程详情
    private Integer limit_buy;//限售
    private Integer sold;//已售
    private String cs_time;//课时
    private String t_name;//教师名称
    private String t_desc;//教师简介

    private String cs_img;//课程图片
    private String order_img;
    private String video;//视频

    private Integer cat_id;//分类id
    private Integer te_id;//教师id
}
