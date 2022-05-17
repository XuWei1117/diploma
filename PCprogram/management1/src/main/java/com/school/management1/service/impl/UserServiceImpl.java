package com.school.management1.service.impl;

import com.school.management1.domain.User;
import com.school.management1.mapper.UserMapper;
import com.school.management1.service.UserService;
import com.school.management1.domain.User;
import com.school.management1.mapper.UserMapper;
import com.school.management1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByName(User user) {
        User user1 = userMapper.selectByName(user.getU_name());
        return user1;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }


}
