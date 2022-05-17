package com.school.management1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer c_id;
    private String c_name;
    private List<Course> Courses;
}
