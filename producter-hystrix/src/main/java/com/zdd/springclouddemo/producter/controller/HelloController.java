package com.zdd.springclouddemo.producter.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackSayHello")
    public String sayHello(@RequestParam(name = "name") String name){
        if("hystrix".equals(name)){
            throw new RuntimeException("服务降级测试");
        }
        return "hello,"+name;
    }

    public String fallbackSayHello(String name){
        return "服务降级测试"+name;
    }
}
