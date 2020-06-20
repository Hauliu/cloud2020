package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-08 20:46
 */

@Component //使SpringBoot容器可以扫描的到类中的内容
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;

        do{
            //得到当前的值
            current = atomicInteger.get();
            //对比current是否大于 2147483647,如果大于，那么等于零，如果没有大于，那么current+1
            next = current >= Integer.MAX_VALUE ? 0 : current +1;
            //希望值是current,修改值是next.如果不符合条件，那么将一直循环到符合条件为止
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第"+next+"次访问next>>>>>"+current);
        return next;

    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
