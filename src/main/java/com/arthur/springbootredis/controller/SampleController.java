package com.arthur.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){

        redisTemplate.opsForValue().set("hello", "test");

        return "test controller";
    }
}
