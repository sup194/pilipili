package com.pilipili.server.service;

import com.pilipili.server.dto.ResourceDto;
import com.pilipili.server.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资源 服务类
 * </p>
 *
 * @author sup194
 * @since 2020-10-22
 */
public interface ResourceService extends IService<Resource> {

    void saveJson(String jsonStr);

    List<ResourceDto> loadTree();
}
