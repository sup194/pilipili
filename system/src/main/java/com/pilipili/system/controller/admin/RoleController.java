package com.pilipili.system.controller.admin;

import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.RoleDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pilipili.server.service.RoleService;
import com.pilipili.server.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Slf4j
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {


    @Autowired
    private RoleService roleService;

    //    List列表查询

    @GetMapping("/list")
    public ResponseDto list() {
        log.info("权限列表");
        Page<Role> aPage = roleService.page(new Page<>(1, 6));
        return ResponseDto.success(aPage);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody RoleDto roleDto) {


        // 保存校验
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(roleDto);
        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }

        Role role = CopyUtil.copy(roleDto, Role.class);
        roleService.saveOrUpdate(role);
        return ResponseDto.success(roleDto);
    }
    /**
     * 保存资源
     * @param roleDto
     */
    @PostMapping("/save-resource")
    public ResponseDto saveResource(@RequestBody RoleDto roleDto) {
        log.info("保存角色资源关联开始");
        roleService.saveResource(roleDto);
        return ResponseDto.success();
    }

    /**
     * 加载已关联的资源
     */
    @GetMapping("/list-resource/{roleId}")
    public ResponseDto listResource(@PathVariable String roleId) {
        log.info("加载资源开始");
//        按roleId查询资源表
        Role role = roleService.getById(roleId);
        return ResponseDto.success(role);
    }

    /**
     * 保存用户
     * @param roleDto
     */
    @PostMapping("/save-user")
    public ResponseDto saveUser(@RequestBody RoleDto roleDto) {
        log.info("保存角色用户关联开始");
        Role role = CopyUtil.copy(roleDto, Role.class);
        roleService.save(role);
        return ResponseDto.success(roleDto);
    }

    /**
     * 加载用户
     * @param roleId
     */
    @GetMapping("/list-user/{roleId}")
    public ResponseDto listUser(@PathVariable String roleId) {
        log.info("加载用户开始");
        List<String> resourceIdList = roleService.listResource(roleId);
        return ResponseDto.success(resourceIdList);
    }



    //通过ID删除

    @PostMapping(value = "/delete/{id}")
    public ResponseDto delete(@PathVariable("id") String id) {
        roleService.removeById(id);
        return ResponseDto.success();
    }

}
