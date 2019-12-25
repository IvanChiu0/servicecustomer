package com.example.servicecustomer01.feignService;

import com.example.servicecustomer01.feignService.impl.CustomerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Service
//指定服务名称，以及返回信息的处理方法
@FeignClient(value = "SERVICECLIENT",fallback = CustomerServiceImpl.class)
public interface CustomerService {

    @PostMapping("/serviceclient/discovery/query") //指定服务路径
    String query();

    @PostMapping("/serviceclient/discovery/hystrix")
    String hystrix(@RequestParam("param") String param);
}
