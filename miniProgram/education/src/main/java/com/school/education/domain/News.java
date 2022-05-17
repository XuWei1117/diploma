package com.school.education.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private Integer n_id;
    private String n_title;
    private String n_detail1;
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date n_date;
}
