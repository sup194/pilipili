package com.pilipili.system.controller.admin;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pilipili.server.dto.*;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.service.UserService;
import com.pilipili.server.util.UuidUtil;
import com.pilipili.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pilipili.server.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 角色用户关联 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Slf4j
@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    //login
    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginDto loginDto) {
        log.info("用户登录开始");
//        loginDto.setPassword(DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()));

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

    //list
    @GetMapping("/list")
    public ResponseDto list() {
        LOG.info("用户查询");
        Page<User> aPage = userService.page(new Page<>(1, 6));
        return ResponseDto.success(aPage);
    }


    //  通过ID删除
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable("id") String id) {
        userService.removeById(id);
        return ResponseDto.success();
    }

    /**
     * 重置密码
     */
    @PostMapping("/save-password")
    public ResponseDto savePassword(@RequestBody UserDto userDto) {
        userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        User user = userService.getById(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        userService.saveOrUpdate(user);
        return ResponseDto.success();
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout/{token}")
    public ResponseDto logout(@PathVariable String token) {
        redisTemplate.delete(token);
        LOG.info("从redis中删除token:{}", token);
        return ResponseDto.success();
    }

}
