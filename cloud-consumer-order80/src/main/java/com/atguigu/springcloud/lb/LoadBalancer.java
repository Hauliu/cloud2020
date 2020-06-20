package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    //在这个方法中可以得到里面的list对象
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
