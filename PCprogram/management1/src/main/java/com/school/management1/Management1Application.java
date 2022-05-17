package com.school.management1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.school.management1.mapper")
@SpringBootApplication
public class Management1Application {

    public static void main(String[] args) {
        SpringApplication.run(Management1Application.class, args);
    }

}
