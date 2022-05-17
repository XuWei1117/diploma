package com.school.management1.domain.vo;



import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO extends PageInfo {
    private Integer comment_id;
    private String user_name;//评论人
    private String comment_desc;//评论内容
    private Date comment_date;//评论时间
    private String course_name;//评论的课程

    private String condition;//用于接收模糊查询的参数
    private String conditionNew;//用于接收模糊查询的参数
}
