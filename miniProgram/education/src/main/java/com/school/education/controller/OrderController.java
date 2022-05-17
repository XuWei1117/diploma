package com.school.education.controller;

import com.school.education.domain.CourseTeacher;
import com.school.education.domain.OrderTeacher;
import com.school.education.service.CourseTeacherService;
import com.school.education.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有关订单的操作
 */
@Controller
@RequestMapping("/education/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private CourseTeacherService courseTeacherService;

    /**
     * 购买课程
     * 1代表已支付
     * 0代表未支付
     * @param
     * @return
     */
    //CourseTeacher courseTeacher,Integer r_status,Integer user_id
    @RequestMapping("/buyCourse")
    public @ResponseBody Map<String ,String> buyCourse(@RequestParam("cs_id") Integer cs_id,@RequestParam("r_status") Integer r_status,@RequestParam("user_id") Integer user_id){
        CourseTeacher courseTeacher = courseTeacherService.selectByCsId(cs_id);
        System.out.println("courseTeacher = " + courseTeacher);
        OrderTeacher orderTeacher = new OrderTeacher();
        orderTeacher.setR_name(courseTeacher.getCs_name());
        orderTeacher.setR_img(courseTeacher.getOrder_img());
        orderTeacher.setR_price(courseTeacher.getCs_price());
        orderTeacher.setR_teacher(courseTeacher.getTe_id());
        orderTeacher.setCourse_id(courseTeacher.getCs_id());
        orderTeacher.setR_video(courseTeacher.getVideo());
        HashMap<String, String> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
        String format = sdf.format(new Date());
        orderTeacher.setR_number(format);
        orderTeacher.setR_status(r_status);
        //设置订单关联的用户
        orderTeacher.setUser_id(user_id);
        System.out.println(orderTeacher);
        Integer count = service.orderFinish(orderTeacher);
        //点击支付之后会生成一个订单，插入到订单表
        //向订单表中插入一行
        if(count == 1){
            if(r_status == 1){
                //说明点击了支付
                //每完成一个订单后，需要将对应课程的售出+1，限购-1
                courseTeacherService.updateSold(courseTeacher);
                map.put("msg","购买成功");
                map.put("code","200");
            }else{
                //之点击了购买，取消了支付，生成一个订单
                map.put("msg","订单生成");
                map.put("code","200");
            }
        }
        return map;
    }

    /**
     * 显示已支付的订单
     * @return
     */
    @RequestMapping("/showFinishOrder")
    public @ResponseBody List<OrderTeacher> showFinishOrder(@RequestParam(name = "user_id") Integer user_id){
        List<OrderTeacher> orders = service.showFinishOrder(user_id);
        System.out.println(orders);
        return orders;
    }

    /**
     * 显示未支付的订单
     * @return
     */
    @RequestMapping("/showUnFinishOrder")
    public @ResponseBody List<OrderTeacher> showUnFinishOrder(@RequestParam("user_id") Integer user_id){
        List<OrderTeacher> orders = service.showUnfinishOrder(user_id);
        return orders;
    }

    /**
     * 取消未支付的订单
     * @param r_id
     * @return
     */
    @RequestMapping("/deleteOrder")
    public @ResponseBody Map<String ,String> deleteOrder(Integer r_id){
        Integer count = service.deleteOrder(r_id);
        HashMap<String, String> map = new HashMap<>();
        if(count == 1){
            map.put("msg","订单删除成功");
            map.put("code","200");
        }
        return map;
    }
    @RequestMapping("/updateOrder")
    public @ResponseBody Map<String,String> updateOrder(Integer r_id){
        Integer count = service.updateOrder(r_id);
        HashMap<String, String> map = new HashMap<>();
        if(count == 1){
            map.put("msg","订单修改成功");
            map.put("code","200");
        }
        return map;
    }

    @RequestMapping("/getVideo")
    public @ResponseBody Map<String,String> getVideo(@RequestParam("r_id") Integer r_id){
        HashMap<String, String> map = new HashMap<>();
        String video = service.getVideo(r_id);
        map.put("data",video);
        map.put("code","200");
        map.put("msg","视频获取成功");
        return map;
    }
}

