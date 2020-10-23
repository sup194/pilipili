package com.pilipili.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pilipili.server.dto.ResourceDto;
import com.pilipili.server.entity.Resource;
import com.pilipili.server.mapper.ResourceMapper;
import com.pilipili.server.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.CopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-10-19
 */
@Slf4j
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;
    /**
     * 保存资源树
     * @param json
     */
    @Transactional
    public void saveJson(String json) {
        List<ResourceDto> jsonList = JSON.parseArray(json, ResourceDto.class);
        List<ResourceDto> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(jsonList)) {
            for (ResourceDto d: jsonList) {
                d.setParent("");
                add(list, d);
            }
        }
        log.info("共{}条", list.size());

//         ？？？？？？？？？？ delete from resource
//         可以在不删除表的情况下删除所有的行。这意味着表的结构、属性和索引都是完整的：
        resourceMapper.delete(null);

        for (int i = 0; i < list.size(); i++) {
            this.insert(CopyUtil.copy(list.get(i), Resource.class));
        }
    }

    /**
     * 按约定将列表转成树
     * 要求：ID要正序排列
     * @return
     */
    public List<ResourceDto> loadTree() {

//        查找resource的所有列，并以ID为正序的形式排列
        List<Resource> resourceList = resourceMapper
                .selectList(new QueryWrapper<Resource>().orderByAsc("id"));

        log.info(String.valueOf(resourceList));

        List<ResourceDto> resourceDtoList = CopyUtil.copyList(resourceList, ResourceDto.class);
        for (int i = resourceDtoList.size() - 1; i >= 0; i--) {
            // 当前要移动的记录
            ResourceDto child = resourceDtoList.get(i);

            // 如果当前节点没有父节点，则不用往下了
            if (StringUtils.isEmpty(child.getParent())) {
                continue;
            }
            // 查找父节点
            for (int j = i - 1; j >= 0; j--) {
                ResourceDto parent = resourceDtoList.get(j);
                if (child.getParent().equals(parent.getId())) {
                    if (CollectionUtils.isEmpty(parent.getChildren())) {
                        parent.setChildren(new ArrayList<>());
                    }
                    // 添加到最前面，否则会变成倒序，因为循环是从后往前循环的
                    parent.getChildren().add(0, child);

                    // 子节点找到父节点后，删除列表中的子节点
                    resourceDtoList.remove(child);
                }
            }
        }
        return resourceDtoList;
    }





    /**
     * 递归，将树型结构的节点全部取出来，放到list
     * @param list
     * @param dto
     */
    public void add(List<ResourceDto> list, ResourceDto dto) {
        list.add(dto);
        if (!CollectionUtils.isEmpty(dto.getChildren())) {
            for (ResourceDto d: dto.getChildren()) {
                d.setParent(dto.getId());
                add(list, d);
            }
        }
    }

    /**
     * 新增，ID是自定义好的，不是自动生成的
     */
    private void insert(Resource resource) {
        resourceMapper.insert(resource);
    }
}
