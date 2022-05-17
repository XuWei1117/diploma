package com.school.education.mapper;

import com.school.education.domain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    Integer login(User user);
    Integer updateById(User user);
    User selectByOpenId(String u_openId);
    User selectByName(String u_name);
    void updateNameById(User user);
    void updateProvinceById(User user);
    void updateCityById(User user);


}
