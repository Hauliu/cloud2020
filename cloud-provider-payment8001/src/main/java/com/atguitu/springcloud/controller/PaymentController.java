package com.atguitu.springcloud.controller;

import com.atguitu.springcloud.entites.CommonResult;
import com.atguitu.springcloud.entites.Payment;
import com.atguitu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servePort;

    //服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int index = paymentService.create(payment);
        log.info("我说数据的插入" + index);

        if (index > 0) {
            return new CommonResult(200, "数据插入成功" + servePort, index);
        } else {
            return new CommonResult(444, "数据插入失败" + servePort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment index = paymentService.getPaymentById(id);
        log.info("透过表象看内心" + index);

        if (index != null) {
            return new CommonResult(200, "数据查询成功" + servePort, index);
        } else {
            return new CommonResult(444, "数据查询失败，没有数据" + servePort, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {

        //第一个获取自己信息的方法，遍历
        List<String> services = discoveryClient.getServices();
        for(String list : services){

            log.info("instance>>>>"+list);
        }

        //第二个获取自己信息的方法
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return servePort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeout(){//超时服务

        try{

            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return servePort;
    }
    }
