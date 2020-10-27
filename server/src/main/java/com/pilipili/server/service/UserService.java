package com.pilipili.server.service;

import com.pilipili.server.dto.LoginDto;
import com.pilipili.server.dto.LoginUserDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

    UserDto getByUserId(String userId);
}
