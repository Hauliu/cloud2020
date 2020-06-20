package com.atguitu.springcloud.service.impl;

import com.atguitu.springcloud.dao.PaymentDao;
import com.atguitu.springcloud.entites.Payment;
import com.atguitu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    // 常规写法为create,update,delete
    public int create(Payment payment){
        return this.paymentDao.create(payment);
    }
    //查询操作
    public Payment getPaymentById(Long id){
        return this.paymentDao.getPaymentById(id);
    }

    //修改操作
    public Payment update(Payment payment) {
        return this.paymentDao.update(payment);
    }
}
