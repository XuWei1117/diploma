package com.school.education.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTeacher {
    /*
     * 订单id
     * 订单编号
     * 订单上显示的课程名称
     * 课程价格
     * 授课老师
     * 订单状态：是否支付*/
    private Integer r_id;
    private String r_number;
    private String r_img;
    private String r_name;
    private double r_price;
    private Integer r_teacher;
    private Integer r_status;
    private Integer course_id;
    private Integer user_id;
    private String r_video;


    private Integer t_id;//教师id
    private String t_name;//教师名称
    private String t_desc;//教师描述
    private String t_img;//教师头像
}
