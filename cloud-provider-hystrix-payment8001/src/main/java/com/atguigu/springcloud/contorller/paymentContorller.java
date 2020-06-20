package com.atguigu.springcloud.contorller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-09 19:46
 */
@RestController
@Slf4j
public class paymentContorller {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/get/{id}")
    public String paymentgetInfo_OK(@PathVariable("id") Integer id) {

        String result = paymentService.getInfo_OK(id);
        log.info("**********result::" + result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/get/{id}")
    public String getTimeout(@PathVariable("id") Integer id) {


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String date1 = sdf.format(date);
        System.out.println(date1);
        String result = paymentService.getTimeout(id);
        System.out.println(date1);
        log.info("**********result::" + result);
        return result;
    }

    //======服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }


}
