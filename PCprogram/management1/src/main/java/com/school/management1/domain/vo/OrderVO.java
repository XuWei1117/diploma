package com.school.management1.domain.vo;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO extends PageInfo {
    private Integer r_id;//订单的id
    private String r_number;//订单编号
    private String r_name;//课程名称
    private Double r_price;//课程价格
    private String r_teacher;//老师名称
    private Integer r_status;//订单状态（已支付 未支付）
    private String user_name;//用户名称

    private String condition;//搜索条件
    private String conditionNew;//搜索条件
}
