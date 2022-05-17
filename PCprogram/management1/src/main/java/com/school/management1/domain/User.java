package com.school.management1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends PageInfo {
    private Integer u_id;
    private String u_name;
    private Integer u_gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date u_newLogin;
    private String u_img;
    private String u_password;
}
