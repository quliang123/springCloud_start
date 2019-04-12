package com.example.controller;

import com.example.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 123
 */
@RestController
public class HiController {

    /**
     * schedualServiceHi   这个地方在idea 中可能会报错,但是运行起来是没问题的
     */
    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        System.out.println("name = " + name);
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
