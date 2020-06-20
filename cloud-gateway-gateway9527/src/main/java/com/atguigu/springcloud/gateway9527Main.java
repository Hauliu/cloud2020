package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-18 18:44
 */

@SpringBootApplication
@EnableEurekaClient
public class gateway9527Main {
    public static void main(String[] args){
        SpringApplication.run(gateway9527Main.class,args);
        System.out.println("gateway9527Main启动成功");
    }

}
