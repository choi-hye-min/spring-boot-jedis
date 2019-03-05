package com.arthur.springbootredis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){
        return "test controller";
    }
}
