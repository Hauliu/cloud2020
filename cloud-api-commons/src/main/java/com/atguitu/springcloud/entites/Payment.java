package com.atguitu.springcloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor//全参
@NoArgsConstructor//空参
    public class Payment implements Serializable//序列化，分布式部署
    {
        private Long id;
        private String serial;

}
