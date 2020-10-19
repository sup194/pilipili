package com.pilipili.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pilipili.server.entity.Category;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> selectList();

    void save(Category category);

    int updateById(Category category);


}
