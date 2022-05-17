package com.school.education.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer u_id;
    private String u_name;
    private Integer u_gender;
    private Date u_newLogin;
    private String u_img;
}
