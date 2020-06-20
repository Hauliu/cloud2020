package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-08 21:55
 */

@SpringBootApplication
@EnableFeignClients
public class OderFeignMain80 {
    public static void main(String[] args){
        SpringApplication.run(OderFeignMain80.class,args);
        System.out.println("启动OderFeignMain80成功");
    }
}
