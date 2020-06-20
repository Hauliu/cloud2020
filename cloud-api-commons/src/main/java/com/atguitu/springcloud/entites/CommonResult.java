package com.atguitu.springcloud.entites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//全参
@NoArgsConstructor//空参
public class CommonResult<T>//返回前端一个通用的json通用实体串
{
    //返回全参构造方法
    private Integer code;
    private String message;
    private T data;

    //返回两个参数的构造方法
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
