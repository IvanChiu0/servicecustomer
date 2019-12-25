package com.example.servicecustomer01.configuration;

import com.example.servicecustomer01.iRule.MyIRule;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRegistration;

@Configuration
public class Config {

    /**
     * ribbon访问引擎
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule iRule() {
//        return new MyIRule();
//    }

}
