package com.example.servicecustomer01.controller;

import com.example.servicecustomer01.feignService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/example")
    public String example() {
//        return restTemplate.postForObject("http://SERVICECLIENT/serviceclient/discovery/query","hey",String.class);
        return customerService.query();
    }

    @PostMapping("/hystrix")
    public String hystrix(@RequestParam("param") String param) {
        return customerService.hystrix(param);
    }
}
