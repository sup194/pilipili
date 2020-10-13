package com.pilipili.system.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.PageDto;
import com.pilipili.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected UserService userService;

    public Page getPage(PageDto pageDto) {
        int current = pageDto.getPage() != null ? pageDto.getPage() : 1;
        int size = pageDto.getSize() != null ? pageDto.getSize() : 5;
        return new Page(current, size);
    }

}
