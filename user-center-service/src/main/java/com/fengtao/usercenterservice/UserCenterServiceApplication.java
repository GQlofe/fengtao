package com.fengtao.usercenterservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@MapperScan("com.fengtao.usercenterservice.dao")
public class UserCenterServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserCenterServiceApplication.class, args);
    }

}
