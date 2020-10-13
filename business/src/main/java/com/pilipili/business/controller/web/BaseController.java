package com.pilipili.business.controller.web;

import com.pilipili.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected RedisTemplate redisTemplate;
}