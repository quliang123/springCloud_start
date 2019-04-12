package com.ql.servcie;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 123
 * @date 2019年4月11日15:40:22
 * 调用服务
 * 服务短路器
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate RestTemplate;

    /**
     * @param name
     * @return
     * @HystrixCommand(fallbackMethod = "短路方法")
     * 短路异常注解
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        System.out.println(name);
        return RestTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
    }

    /**
     *     短路异常被触发的方法
     */
    public String hiError(String name) {
        return "hi," + name + ",sorry,error";
    }
}
