package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-09 19:22
 */

@Service
public class PaymentService {

    //正常访问，一切OK
    public String getInfo_OK(Integer id){

        return "线程池：  "+Thread.currentThread().getName()+" paymentInfo_ok  id:"+id+"\t"+"😊😊😊😊😊😊😊😊";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //3秒钟以内就是正常的业务逻辑

    })
    public String getTimeout(Integer id){

        int timeNumber = 5;
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "线程池：  "+Thread.currentThread().getName()
                +" paymentInfo_ok  id:"+id+"\t"+"😊😊😊😊😊😊😊😊"+"  耗时"+timeNumber+"秒钟";
    }


    public String paymentInfo_TimeoutHandler(Integer id){

        return "线程池：  "+Thread.currentThread().getName()
                +" 8001系统繁忙，请稍后再试  id:"+id+"\t"+"/(ㄒoㄒ)/~~";

    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();//这里的作用只是一个独特ID，参考 "糊涂"手册

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }




}
