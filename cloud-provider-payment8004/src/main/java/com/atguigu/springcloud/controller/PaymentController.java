package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-05 13:56
 */

@Controller
@Slf4j
public class PaymentController {

    @GetMapping(value = "/ok")
    public String test(){
        return "测试";
    }
}
