package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2020
 * @author: insist 刘萌萌yy
 * @create: 2020-06-20 10:59
 */

@Configuration
public class GetWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){//RouteLocatorBuilder 路由构建器

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocatorTowGuowai(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder roust = routeLocatorBuilder.routes();
        roust.route("Path_route_atguigu",r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return roust.build();
    }
}
