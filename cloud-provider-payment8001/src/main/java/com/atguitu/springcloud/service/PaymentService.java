package com.atguitu.springcloud.service;

import com.atguitu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Param;

//service接口
public interface PaymentService {

    // 常规写法为create,update,delete
    public int create(Payment payment);

    //查询操作
    public Payment getPaymentById(@Param("id") Long id);

    //修改操作
    //修改的方式
    public Payment update(Payment payment);
}
