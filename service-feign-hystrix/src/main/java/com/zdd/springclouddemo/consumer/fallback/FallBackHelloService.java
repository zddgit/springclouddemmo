package com.zdd.springclouddemo.consumer.fallback;

import com.zdd.springclouddemo.service.IHelloService;
import org.springframework.stereotype.Component;

@Component
public class FallBackHelloService implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "服务熔断"+name;
    }
}
