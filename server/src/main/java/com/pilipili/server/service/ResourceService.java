package com.pilipili.server.service;

import com.pilipili.server.dto.ResourceDto;
import com.pilipili.server.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色资源关联 服务类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
public interface ResourceService extends IService<Resource> {

    void saveJson(String jsonStr);

    List<ResourceDto> loadTree();
}
