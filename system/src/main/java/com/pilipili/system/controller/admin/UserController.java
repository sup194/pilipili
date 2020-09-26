package com.pilipili.system.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pilipili.server.dto.PageDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pilipili.server.entity.User;

/**
 * <p>
 * 角色用户关联 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    public static final String BUSINESS_NAME = "用户";





    @GetMapping(value = "/")
    public ResponseEntity<Page<User>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<User> aPage = userService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody User params) {
        userService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        userService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
