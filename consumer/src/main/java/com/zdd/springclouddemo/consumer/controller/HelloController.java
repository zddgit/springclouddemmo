package com.zdd.springclouddemo.consumer.controller;

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
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        System.out.println(discoveryClient.getServices());
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTER");
        System.out.println(String.format("host=%s,port=%s,serviceId=%s",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getServiceId()));
        return  restTemplate.getForObject("http://PRODUCTER/sayHello?name="+name,String.class);
    }
}

