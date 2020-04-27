package com.example.vhrapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.example.vhrapi.mapper")
public class VhrApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrApiApplication.class, args);
    }

}
