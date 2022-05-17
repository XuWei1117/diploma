package com.school.education.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swiper {
    private Integer id;
    private String carousel;
    private Integer category_id;
}
