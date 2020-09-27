package com.pilipili.business.controller.web;


import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.entity.User;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
