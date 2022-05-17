package com.school.management1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class r_order {
    private Integer r_id;//订单列表
    private String r_number;//订单编号
    private String r_name;//课程名称
    private Integer r_teacher;//教师id
    private Integer r_status;//课程状态
    private Integer user_id;//购买用户
}
