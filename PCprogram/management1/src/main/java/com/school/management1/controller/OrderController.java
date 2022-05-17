package com.school.management1.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.management1.domain.vo.OrderVO;
import com.school.management1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/management/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderList")
    public PageInfo<OrderVO> getOrderList(@RequestBody OrderVO order){
        if (null == order || null == String.valueOf(order.getPageNum())) {
            order.setPageNum(1);
        }
        if (null == order || null == String.valueOf(order.getPageSize())) {
            order.setPageSize(10);
        }
        PageHelper.startPage(order.getPageNum(), order.getPageSize());
        order.setConditionNew("%" + order.getCondition() + "%");
        List<OrderVO> orderVOS = orderService.orderListPage(order);
        PageInfo<OrderVO> pageInfo = new PageInfo<>(orderVOS);
        return pageInfo;
    }
    @RequestMapping("/payOrder")
    public HashMap<String,Object> payOrder(@RequestBody OrderVO order) throws Exception {
        if (order.getR_id() == null){
            throw new Exception("订单id不能为空");
        }
        Integer count = orderService.payOrder(order);
        HashMap<String, Object> map = new HashMap<>();
        if(count == 1){
            map.put("msg","支付成功");
            map.put("code","200");
        }
        return map;
    }
    @RequestMapping("/deleteOrder")
    public HashMap<String,Object> deleteOrder(@RequestBody OrderVO order) throws Exception {
        if (order.getR_id() == null){
            throw new Exception("订单id不能为空");
        }
        Integer count = orderService.deleteOrder(order);
        HashMap<String, Object> map = new HashMap<>();
        if(count == 1){
            map.put("msg","删除成功");
            map.put("code","200");
        }
        return map;
    }
}
