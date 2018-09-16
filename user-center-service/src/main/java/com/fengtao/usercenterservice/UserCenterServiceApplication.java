package com.fengtao.usercenterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class UserCenterServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserCenterServiceApplication.class, args);
    }
}
