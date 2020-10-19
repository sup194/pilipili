package com.pilipili.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Role;

import java.util.List;

public interface CategoryService  {
    List<Category> List();

    void save(Category category);


    void updateById(Category category);
}
