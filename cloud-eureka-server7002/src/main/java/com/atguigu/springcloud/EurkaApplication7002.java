package com.atguigu.springcloud;/**
 * @Author:刘萌萌
 * @Date: Create in #{TIME}&{DATE}
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: cloud2020
 * @description: 服务注册中心
 * @author: insist 刘萌萌yy
 * @create: 2020-06-02 09:18
 */
@EnableEurekaServer
@SpringBootApplication
public class EurkaApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurkaApplication7002.class, args);
        System.out.println("EurekaApplication7002.class 启动成功！！！");
    }
}
