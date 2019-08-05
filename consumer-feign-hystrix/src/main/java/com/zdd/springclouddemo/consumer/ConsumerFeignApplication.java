package com.zdd.springclouddemo.consumer;

import com.zdd.springclouddemo.ribbonconfig.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.zdd.springclouddemo.service") //feign默认也是使用的ribbon的负载策略
//@RibbonClient(name = "PRODUCTER",configuration = RibbonConfig.class) 这一行用来配置ribbon的负载策略
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class,args);
    }
}
