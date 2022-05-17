package com.school.education.service.impl;

import com.school.education.domain.User;
import com.school.education.mapper.UserMapper;
import com.school.education.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer login(User user) {
        Integer count = userMapper.login(user);
        return count;
    }

    @Override
    public Integer updateById(User user) {
        Integer count = userMapper.updateById(user);
        return count;
    }

    @Override
    public User selectByOpenId(String u_openId) {
        User user = userMapper.selectByOpenId(u_openId);
        return user;
    }

    @Override
    public User selectByName(String u_name) {
        User user = userMapper.selectByName(u_name);
        return user;
    }

    @Override
    public void updateNameById(User user) {
        userMapper.updateNameById(user);
    }

    @Override
    public void updateProvinceById(User user) {
        userMapper.updateProvinceById(user);
    }

    @Override
    public void updateCityById(User user) {
        userMapper.updateCityById(user);
    }


}
