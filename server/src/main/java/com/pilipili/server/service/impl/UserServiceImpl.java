package com.pilipili.server.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.entity.User;
import com.pilipili.server.mapper.UserMapper;
import com.pilipili.server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.UuidUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
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
        this.save(temp);
        return ResponseDto.success(temp);
    }
}
