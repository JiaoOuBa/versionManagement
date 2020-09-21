package com.ulearing.versionmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = {"com"})
public class VersionmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VersionmanagementApplication.class, args);
    }

}
