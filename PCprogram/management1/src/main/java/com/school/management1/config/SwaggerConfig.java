package com.school.management1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("xuwei")
                .enable(flag)//enable是否启动swagger，如果为false，则swagger不能再浏览器中访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.school.management.controller"))
                //.paths(PathSelectors.ant("/"))
                .build();
    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("许伟","http://localhost:8080/swagger-ui.html","3340977460@qq.com");
        return new ApiInfo("未来之星后台管理系统SwaggerAPI文档",
                "SwaggerAPI文档",
                "v1.0",
                "http://localhost:8080/swagger-ui.html",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}

