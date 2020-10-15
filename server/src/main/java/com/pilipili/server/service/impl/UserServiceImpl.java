package com.pilipili.server.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pilipili.server.dto.LoginDto;
import com.pilipili.server.dto.LoginUserDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.entity.User;
import com.pilipili.server.exception.BusinessException;
import com.pilipili.server.exception.BusinessExceptionCode;
import com.pilipili.server.mapper.UserMapper;
import com.pilipili.server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public ResponseDto register(User user) {
        int count = this.count(new QueryWrapper<User>().eq("email", user.getEmail()));
        if (count > 0) {
            return ResponseDto.fail("邮箱已被占用");
        }

        User temp = new User();
        temp.setId(UuidUtil.getShortUuid());
        temp.setEmail(user.getEmail());
        temp.setName(user.getName());
        temp.setPassword(SecureUtil.md5(user.getPassword()));
        temp.setAvatar(null);
        temp.setGender("S");
        temp.setSign("该用户很懒,什么也没有留下...");
        temp.setRole("G");
        this.save(temp);
        return ResponseDto.success();
    }

    @Override
    public LoginUserDto login(LoginDto loginDto) {
        User user = this.getOne(new QueryWrapper<User>().eq("email", loginDto.getEmail()));

        if (user == null) {
            log.info("邮箱不存在, {}", loginDto.getEmail());
            throw new BusinessException(BusinessExceptionCode.LOGIN_EMAIL_ERROR);
        } else {
            if (user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
                //  登录成功
                LoginUserDto loginUserDto = CopyUtil.copy(user, LoginUserDto.class);
                return loginUserDto;
            } else {
                log.info("密码不对, 输入密码：{}, 数据库密码：{}", loginDto.getPassword(), user.getPassword());
                throw new BusinessException(BusinessExceptionCode.LOGIN_EMAIL_ERROR);
            }
        }
    }
}
