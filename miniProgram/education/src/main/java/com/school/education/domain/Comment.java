package com.school.education.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer cm_id;
    private String cm_name;
    private String cm_desc;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date cm_date;
    private Integer course_id;

    private Integer user_id;
    private String u_img;

    private String cs_name;
}
