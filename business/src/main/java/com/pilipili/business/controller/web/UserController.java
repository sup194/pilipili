package com.pilipili.business.controller.web;


import cn.hutool.json.JSONUtil;
import com.pilipili.server.dto.LoginDto;
import com.pilipili.server.dto.LoginUserDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.entity.User;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import com.pilipili.server.util.ValidatorUtil;
import com.pilipili.server.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-26
 */
@Slf4j
@RestController("webUserController")
@RequestMapping("/web/user")
public class UserController extends BaseController {

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseDto register(@RequestBody User user) {
        //  保存验证
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(user);

        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }

        //  完成注册
        ResponseDto responseDto = userService.register(user);

        return responseDto;
    }

    /**
     * 登录
     * @param
     * @return
     */
    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginDto loginDto) {
        log.info("用户登录开始");
        //  验证邮箱密码
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(loginDto);
        if (validResult.hasErrors()) {
            throw new ValidatorException("邮箱或密码不能为空");
        }

        LoginUserDto loginUserDto = userService.login(loginDto);
        String token = UuidUtil.getShortUuid();
        loginUserDto.setToken(token);
        redisTemplate.opsForValue().set(token, JSONUtil.toJsonStr(loginUserDto), 3600, TimeUnit.SECONDS);
        return ResponseDto.success(loginUserDto);
    }


    @GetMapping("/logout/{token}")
    public ResponseDto logout(@PathVariable String token) {

        redisTemplate.delete(token);
        log.info("从redis中删除token:{}", token);

        return ResponseDto.success();
    }

    @PostMapping("/edit")
    public ResponseDto edit(@RequestBody UserVo userVo) {
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(userVo);
        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }

        User user = CopyUtil.copy(userVo, User.class);

        userService.saveOrUpdate(user);
        return ResponseDto.success(userVo);
    }

}
