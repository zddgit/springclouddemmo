package com.zdd.springclouddemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCTER")
public interface IHelloService {

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(name = "name") String name);
}
