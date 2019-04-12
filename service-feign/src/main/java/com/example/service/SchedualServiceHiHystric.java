package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @author 123
 * @date 2019年4月11日15:32:51
 * 服务熔断器
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}
