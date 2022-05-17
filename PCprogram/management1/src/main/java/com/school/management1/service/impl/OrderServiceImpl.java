package com.school.management1.service.impl;

import com.school.management1.domain.vo.OrderVO;
import com.school.management1.mapper.OrderMapper;
import com.school.management1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderVO> orderListPage(OrderVO order) {
        List<OrderVO> orderVOS = orderMapper.orderListPage(order.getCondition(),order.getConditionNew(),order.getR_status());
        return orderVOS;
    }

    @Override
    public Integer payOrder(OrderVO order) {
        Integer count = orderMapper.payOrder(order);
        return count;
    }

    @Override
    public Integer deleteOrder(OrderVO order) {
        Integer count = orderMapper.deleteOrder(order.getR_id());
        return count;
    }


}
