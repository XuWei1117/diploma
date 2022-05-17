package com.school.management1.service;


import com.school.management1.domain.User;

import java.util.List;

public interface UserService {

    User selectByName(User user);
    List<User> selectAllUser();

}
