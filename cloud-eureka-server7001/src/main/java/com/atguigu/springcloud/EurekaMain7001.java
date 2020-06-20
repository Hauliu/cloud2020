package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * /**
 *
 * @Author:刘萌萌
 * @Date: 2020/6/1
 */
@SpringBootApplication
@EnableEurekaServer//服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
        System.out.println("EurekaMain7001，启动成功");
    }
}

