package com.pilipili.server.service.impl;

import com.pilipili.server.dto.RoleDto;
import com.pilipili.server.entity.Role;
import com.pilipili.server.entity.Resource;
import com.pilipili.server.mapper.ResourceMapper;
import com.pilipili.server.mapper.RoleMapper;
import com.pilipili.server.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.UuidUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @javax.annotation.Resource
    ResourceMapper resourceMapper;
    /**
     * 按角色保存资源
     */
    @Override
    public void saveResource(RoleDto roleDto) {
        String roleId = roleDto.getId();
        List<String> resourceIds = roleDto.getResourceIds();
        // 清空库中所有的当前角色下的记录

        resourceMapper.deleteById(roleId);

        // 保存角色资源
//        for (int i = 0; i < resourceIds.size(); i++) {
//            Resource resource = new Resource();
//            resource.setId(UuidUtil.getShortUuid());
//            resource.setRoleId(roleId);
//            resource.setResourceId(resourceIds.get(i));
//            resourceMapper.insert(resource);
//        }
    }

        // 加载用户资源
    @Override
    public List<String> listResource(String roleId) {

//        数组指定唯一的roleId进行查询
        List<Resource> roleResourceList = resourceMapper.selectBatchIds(Collections.singleton(roleId));

        List<String> resourceIdList = new ArrayList<>();
//        for (int i = 0, l = roleResourceList.size(); i < l; i++) {
//            resourceIdList.add(roleResourceList.get(i).getResourceId());
//        }
        return resourceIdList;
    }


}
