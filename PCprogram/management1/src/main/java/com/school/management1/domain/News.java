package com.school.management1.domain;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News extends PageInfo {
    private Integer n_id;
    private String n_title;
    private String n_detail1;
    private Date n_date;
    private String n_date_str;
    private String condition;
    private String conditionNew;
}
