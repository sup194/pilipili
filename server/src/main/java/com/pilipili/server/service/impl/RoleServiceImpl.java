package com.pilipili.server.service.impl;

import com.pilipili.server.entity.Role;
import com.pilipili.server.mapper.RoleMapper;
import com.pilipili.server.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
