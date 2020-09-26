package com.pilipili.system.controller.admin;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pilipili.server.service.RoleService;
import com.pilipili.server.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {


    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Role>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Role> aPage = roleService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Role params) {
        roleService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        roleService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
