package com.school.education.mapper;

import com.school.education.domain.Swiper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SwiperMapper {
    List<Swiper> selectSwiper();
}
