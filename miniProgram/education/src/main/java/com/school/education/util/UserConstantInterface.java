package com.school.education.util;

public interface UserConstantInterface {
    // 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // 你的appid
    public static final String WX_LOGIN_APPID = "wx25a411dbe001b984";
    // 你的密匙
    public static final String WX_LOGIN_SECRET = "dd894a5dfa2b8f0f6df519578b03b22f";
    // 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

}
