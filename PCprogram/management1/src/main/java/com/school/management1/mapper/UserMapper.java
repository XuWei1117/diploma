package com.school.management1.mapper;

import com.school.management1.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    User selectByName(String u_name);
    List<User> selectAllUser();


}
