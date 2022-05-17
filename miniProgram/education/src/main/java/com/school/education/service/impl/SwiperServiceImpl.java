package com.school.education.service.impl;

import com.school.education.domain.Swiper;
import com.school.education.mapper.SwiperMapper;
import com.school.education.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SwiperServiceImpl implements SwiperService {
    @Autowired
    private SwiperMapper swiperMapper;
    @Override
    public List<Swiper> selectSwiper() {
        List<Swiper> swipers = swiperMapper.selectSwiper();
        return swipers;
    }
}
