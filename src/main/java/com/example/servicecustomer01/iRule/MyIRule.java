package com.example.servicecustomer01.iRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyIRule extends AbstractLoadBalancerRule {

    /**
     * 假设现在就拿指定的服务
     */
    private static final int INDEX = 0;

    public Server choose(ILoadBalancer lb , Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            //获得可达服务列表
            List<Server> upList = lb.getReachableServers();
            //获取所有服务列表，暂时无用
            List<Server> allList = lb.getAllServers();
            server = upList.get(INDEX);
            if (server == null) {
                //让出线程占用的cpu，重新竞争
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return server;
            }
            // Shouldn't actually happen.. but must be transient or a bug.
            //不应该发生，但还是写写
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
