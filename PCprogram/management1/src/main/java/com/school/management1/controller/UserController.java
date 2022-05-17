package com.school.management1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.management1.domain.User;
import com.school.management1.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/management/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation("显示所有用户列表")
    //只要接口的返回值中存在实体类，他就会被扫描到swagger中
    //http://localhost:8082/management/user/selectAllUser
    @RequestMapping(value = "/selectAllUser")
    public PageInfo<User> selectUser(@RequestBody User user){
        if (null == user || null == String.valueOf(user.getPageNum())) {
            user.setPageNum(1);
        }
        if (null == user || null == String.valueOf(user.getPageSize())) {
            user.setPageSize(10);
        }
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<User> users = userService.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @ApiOperation("管理员登录")
    //只要接口的返回值中存在实体类，他就会被扫描到swagger中
    @PostMapping(value = "/login")
    public HashMap<String, Object> login(@RequestBody User user){
        User user1 = userService.selectByName(user);
        HashMap<String, Object> map = new HashMap<>();
        if(user1 != null){
            //说明用户存在,比较其密码
            if(user.getU_password().equals(user1.getU_password())){
                map.put("msg","登录成功");
                map.put("code","200");
            }else {
                map.put("msg","管理员密码不正确");
                map.put("code","400");
            }
        }else{
            map.put("msg","登录失败，用户名不正确");
            map.put("code","400");
        }
        return map;
    }
}
