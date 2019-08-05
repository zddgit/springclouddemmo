package com.zdd.springclouddemo.consumer.controller;

import com.zdd.springclouddemo.service.IHelloService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private IHelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return  helloService.sayHello(name);
    }
}

