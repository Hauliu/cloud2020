package com.atguigu.springcloud.service;

import com.atguitu.springcloud.entites.CommonResult;
import com.atguitu.springcloud.entites.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-08 22:00
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //CommonResult<Payment> getPaymentById(@Param("id")Long id);

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeout();//超时服务

    }
