package com.atguitu.springcloud.dao;

import com.atguitu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 做数据库操作
 */
@Mapper
public interface PaymentDao {

    // 常规写法为create,update,delete
    public int create(Payment payment);
    //查询操作
    public Payment getPaymentById(@Param("id") Long id);

    //修改的方式
    public Payment update(Payment payment);
}
