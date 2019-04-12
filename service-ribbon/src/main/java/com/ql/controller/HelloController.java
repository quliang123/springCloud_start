package com.ql.controller;
import com.ql.servcie.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**、
 * @author 123
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        System.out.println("name" + name);
        return helloService.hiService(name);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
