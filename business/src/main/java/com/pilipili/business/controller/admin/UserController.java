package com.pilipili.business.controller.admin;

import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.User;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.service.UserService;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import com.pilipili.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-26
 */
@Slf4j
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    UserService userService;
//  通过ID查询用户
    @PostMapping("/selectById/{id}")
    public ResponseDto selectById(@PathVariable("id") String id){
        log.info("通过ID查询");
        if (id.isEmpty()) {
            throw new ValidatorException("ID不能为空");
        }

        User user = userService.getById(id);
        return ResponseDto.success(user);
    }


//    用户修改
    @PostMapping("/updateById")
    public ResponseDto updateById(@RequestBody UserDto userDto){
        log.info("通过ID更新");
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(userDto);

        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }

        User user = CopyUtil.copy(userDto, User.class);
        userService.updateById(user);
        return ResponseDto.success();
    }

}
