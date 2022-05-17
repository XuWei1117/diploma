package com.school.education.controller;

import com.school.education.domain.Swiper;
import com.school.education.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/education/swiper")
@Controller
public class SwiperController {
    @Autowired
    private SwiperService swiperService;
    @RequestMapping("/selectSwiper")
    public @ResponseBody
    List<Swiper> selectSwiper(){
        List<Swiper> swipers = swiperService.selectSwiper();
        return swipers;
    }
}
