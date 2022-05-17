package com.school.management1.service;

import com.school.management1.domain.vo.OrderVO;

import java.util.List;

public interface OrderService {
    List<OrderVO> orderListPage(OrderVO order);
    Integer payOrder(OrderVO order);
    Integer deleteOrder(OrderVO order);
}
