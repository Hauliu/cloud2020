package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-11 19:23
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixFeignOrder80Main {

    public static void main(String[] args){
        SpringApplication.run(HystrixFeignOrder80Main.class,args);
        System.out.println("HystrixFeignOrder80Main启动成功");
    }

}
