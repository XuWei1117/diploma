package com.school.education.service.impl;

import com.school.education.domain.OrderTeacher;
import com.school.education.mapper.OrderTeacherMapper;
import com.school.education.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderTeacherMapper mapper;
    @Override
    public Integer orderFinish(OrderTeacher order) {
        Integer count = mapper.orderFinish(order);
        return count;
    }

    @Override
    public List<OrderTeacher> showFinishOrder(Integer user_id) {
        List<OrderTeacher> orders = mapper.showFinishOrder(user_id);
        return orders;
    }

    @Override
    public List<OrderTeacher> showUnfinishOrder(Integer user_id) {
        List<OrderTeacher> orders = mapper.showUnfinishOrder(user_id);
        return orders;
    }

    @Override
    public Integer deleteOrder(Integer r_id) {
        Integer count = mapper.deleteOrder(r_id);
        return count;
    }

    @Override
    public Integer updateOrder(Integer r_id) {
        Integer count = mapper.updateOrder(r_id);
        return count;
    }

    @Override
    public String  getVideo(Integer r_id) {
        String video = mapper.getVideo(r_id);
        return video;
    }
}
