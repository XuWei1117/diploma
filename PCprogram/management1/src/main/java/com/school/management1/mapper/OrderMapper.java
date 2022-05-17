package com.school.management1.mapper;

import com.school.management1.domain.vo.OrderVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderVO> orderListPage(@Param("condition") String condition,@Param("conditionNew") String conditionNew,@Param("r_status") Integer r_status);
    Integer payOrder(OrderVO order);
    Integer deleteOrder(Integer r_id);

}
