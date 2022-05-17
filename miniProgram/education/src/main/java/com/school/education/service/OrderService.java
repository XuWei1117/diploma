package com.school.education.service;

import com.school.education.domain.OrderTeacher;

import java.util.List;

public interface OrderService {
    Integer orderFinish(OrderTeacher order);
    List<OrderTeacher> showFinishOrder(Integer user_id);
    List<OrderTeacher> showUnfinishOrder(Integer user_id);
    Integer deleteOrder(Integer r_id);
    Integer updateOrder(Integer r_id);
    String getVideo(Integer r_id);
}
