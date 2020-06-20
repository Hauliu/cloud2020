package com.atguigu.springcloud.contorller;

import com.atguigu.springcloud.service.PaymentFeignService;
import com.atguitu.springcloud.entites.CommonResult;
import com.atguitu.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-08 22:10
 */

@RestController
@Slf4j
public class FeignContorller {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumers/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);

    }

    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeout() {//超时服务

        return paymentFeignService.PaymentFeignTimeout();
    }

}
