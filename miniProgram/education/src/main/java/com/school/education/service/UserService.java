package com.school.education.service;

import com.school.education.domain.Comment;
import com.school.education.domain.User;

public interface UserService {
    Integer login(User user);
    Integer updateById(User user);
    User selectByOpenId(String u_openId);
    User selectByName(String u_name);
    void updateNameById(User user);
    void updateProvinceById(User user);
    void updateCityById(User user);
}
