package com.szc.springboot.demo.acs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: sunzhichao
 * @Date: 2018/12/20 13:22
 * @Version: V1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello (String userName) {
        return "Hello "+ userName;
    }
}
