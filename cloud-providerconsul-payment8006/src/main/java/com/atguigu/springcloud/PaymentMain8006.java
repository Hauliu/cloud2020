package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-07 15:41
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8006.class,args);
        System.out.println("PaymentMain8006启动成功");
    }
}
