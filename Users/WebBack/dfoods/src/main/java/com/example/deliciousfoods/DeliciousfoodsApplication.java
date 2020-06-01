package com.example.deliciousfoods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.deliciousfoods.mapper")
@SpringBootApplication
public class DeliciousfoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliciousfoodsApplication.class, args);
    }

}
