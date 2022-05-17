package com.school.management1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer cm_id;//评论id
    private String cm_name;//评论人名称
    private String cm_desc;//评论内容
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cm_date;//评论日期
    private Integer course_id;//评论课程id
    private Integer user_id;//评论用户
}
