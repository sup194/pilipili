package com.pilipili.business.controller.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.PageDto;
import com.pilipili.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class BaseController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected VideoCategoryService videoCategoryService;

    @Autowired
    protected RedisTemplate redisTemplate;

    @Autowired
    protected VideoService videoService;

    @Autowired
    CommentService commentService;

    public Page getPage(PageDto pageDto) {
        int pn = pageDto.getPage() != null ? pageDto.getPage() : 1;
        int size = pageDto.getSize() != null ? pageDto.getSize() : 6;
        return new Page(pn, size);
    }
}
