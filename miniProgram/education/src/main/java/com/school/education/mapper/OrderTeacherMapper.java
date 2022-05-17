package com.school.education.mapper;

import com.school.education.domain.OrderTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderTeacherMapper {
    Integer orderFinish(OrderTeacher order);
    List<OrderTeacher> showFinishOrder(Integer user_id);
    List<OrderTeacher> showUnfinishOrder(Integer user_id);
    Integer deleteOrder(Integer r_id);
    Integer updateOrder(Integer r_id);
    String getVideo(Integer r_id);
}
