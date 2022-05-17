package com.school.management1.domain.vo;

import com.school.management1.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO {
    private Integer id;
    private String category;
    List<Course> courses;
}
