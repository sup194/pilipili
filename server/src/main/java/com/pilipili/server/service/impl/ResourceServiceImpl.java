package com.pilipili.server.service.impl;

import com.pilipili.server.entity.Resource;
import com.pilipili.server.mapper.ResourceMapper;
import com.pilipili.server.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源 服务实现类
 * </p>
 *
 * @author sup194
 * @since 2020-10-22
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
