package com.pilipili.server.service;

import com.pilipili.server.dto.RoleDto;
import com.pilipili.server.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
public interface RoleService extends IService<Role> {


    void saveResource(RoleDto roleDto);

    List<String> listResource(String roleId);

}
