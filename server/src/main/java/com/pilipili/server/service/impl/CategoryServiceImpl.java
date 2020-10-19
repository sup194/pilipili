package com.pilipili.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Role;
import com.pilipili.server.mapper.CategoryMapper;
import com.pilipili.server.mapper.RoleMapper;
import com.pilipili.server.service.CategoryService;
import com.pilipili.server.util.Base64ToMultipartFile;
import com.pilipili.server.util.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> List() {
        return categoryMapper.selectList();
    }

    @Override
    public void save(Category category) {
        categoryMapper.save(category);
    }

    @Override
    public void updateById(Category category) {
        categoryMapper.updateById(category);
    }
}
