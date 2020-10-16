package com.pilipili.server.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.LoginDto;
import com.pilipili.server.dto.LoginUserDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
public interface UserService extends IService<User> {



    ResponseDto register(User user);

    LoginUserDto login(LoginDto loginDto);

    IPage<UserDto> paging(Page page, QueryWrapper<User> wrapper);

}
