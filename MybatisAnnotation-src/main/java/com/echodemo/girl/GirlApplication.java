package com.echodemo.girl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.echodemo.girl.mapper")
public class GirlApplication {

    public static void main(String[] args) {

        SpringApplication.run(GirlApplication.class, args);
    }
}
