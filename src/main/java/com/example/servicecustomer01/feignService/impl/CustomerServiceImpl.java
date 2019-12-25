package com.example.servicecustomer01.feignService.impl;

import com.example.servicecustomer01.feignService.CustomerService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Override
    public String query() {
        return null;
    }

    @Override
    public String hystrix(String param) {
        return "消费者熔断处理方法:" + param;
    }
}
