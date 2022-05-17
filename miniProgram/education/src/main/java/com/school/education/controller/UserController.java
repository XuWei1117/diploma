package com.school.education.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.school.education.domain.User;
import com.school.education.service.UserService;
import com.school.education.util.HttpClientUtil;
import com.school.education.util.UserConstantInterface;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/education")
public class UserController {
    @Autowired
    private UserService userService;



//    public Map<String, Object> getUserInfo(@RequestBody HashMap<String,Object> s) throws Exception {
//        Map<String, Object> result = new HashMap<String, Object>();
//        String url = "https://api.weixin.qq.com/sns/jscode2session";
//        url += "?appid=wx25a411dbe001b984";//自己的appid
//        url += "&secret=dd894a5dfa2b8f0f6df519578b03b22f";//密匙
//        url += "&js_code=" + s.get("code");
//        url += "&grant_type=authorization_code";
//        byte[] res = null;
//        HttpClient httpclient = new DefaultHttpClient();
//        HttpGet httpget = new HttpGet(url);
//        HttpResponse response = null;
//        try {
//            response = httpclient.execute(httpget);
//            res = IOUtils.toByteArray(response.getEntity().getContent());
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            if (httpget != null) {
//                httpget.abort();
//            }
//            httpclient.getConnectionManager().shutdown();
//        }
//        JSONObject jo = JSON.parseObject(new String(res, "utf-8"));
//        System.out.println("jo = " + jo);
//
//        String open_id = jo.getString("openid");
//        System.out.println("s.get(\"code\") = " + s.get("code"));
//        System.out.println("获取到的openID为"+open_id);
//
//
//        //通过用户的code获取到用户的openid
//        //根据openID去数据库查询用户记录是否存在(用户之前是否登录过)
//        User user = userService.selectByOpenId(open_id);
//        System.out.println("根据openID查询到的用户信息为"+user);
//        System.out.println("s.get(\"u_name\") = " + s.get("u_name"));
//        System.out.println("s.get(\"u_gender\") = " + s.get("u_gender"));
//
//        //如果查询到，说明用户登录过
//        if(user != null){
//            //查询到的用户的登录时间进行修改
//            user.setU_newLogin(new Date());
//            userService.updateById(user);
//            //说明昵称不一样需要进行修改
//            if(!user.getU_name().s(s.get("u_name"))){
//                user.setU_name((String) s.get("u_name"));
//                userService.updateNameById(user);
//            }
//            //修改了省市
//            if(!user.getU_province().equals(s.get("u_province"))){
//                user.setU_province((String) s.get("u_province"));
//                userService.updateProvinceById(user);
//            }
//            //修改了城市
//            if(!user.getU_city().equals(s.get("u_city"))){
//                user.setU_city((String) s.get("u_city"));
//                userService.updateCityById(user);
//            }
//            result.put("msg","用户再次登录");
//            result.put("code","200");
//        }else{
//            User user1 = new User();
//            //查询不到用户信息，将用户信息插入到数据库中
//            user1.setU_name((String) s.get("u_name"));
//            user1.setU_gender((Integer) s.get("u_gender"));
//            user1.setU_city((String) s.get("u_city"));
//            user1.setU_province((String) s.get("u_province"));
//            user1.setU_openId(open_id);
//            user1.setU_newLogin(new Date());
//            Integer count = userService.login(user1);
//            if(count == 1){
//                result.put("msg","首次授权登录");
//                result.put("code","200");
//            }
//        }
//        return result;
//
//    }


    @ResponseBody
    @PostMapping("/me/login")
    public Map<String, Object> getUserInfo(@RequestBody HashMap<String,Object> s) {
        Map<String, Object> result = new HashMap<>();
        String u_name = (String) s.get("u_name");
        User user = userService.selectByName(u_name);
        //如果查询到，说明用户登录过
        if(user != null){
            //查询到的用户的登录时间进行修改
            user.setU_newLogin(new Date());
            userService.updateById(user);
            //说明昵称不一样需要进行修改
            if(!user.getU_name().equals(s.get("u_name"))){
                user.setU_name((String) s.get("u_name"));
                userService.updateNameById(user);
            }
            result.put("u_id",user.getU_id());
            result.put("msg","用户再次登录");
            result.put("code","200");
        }else{
            User user1 = new User();
            //查询不到用户信息，将用户信息插入到数据库中
            user1.setU_name((String) s.get("u_name"));
            user1.setU_gender((Integer) s.get("u_gender"));
            user1.setU_newLogin(new Date());
            user1.setU_img((String) s.get("u_img"));
            Integer count = userService.login(user1);
            if(count == 1){
                result.put("msg","首次授权登录");
                result.put("code","200");
                result.put("u_id",user1.getU_id());
            }
        }
        return result;
    }
}
