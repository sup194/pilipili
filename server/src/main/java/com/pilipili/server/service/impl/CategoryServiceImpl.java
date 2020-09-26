package com.pilipili.server.service.impl;

import com.pilipili.server.entity.Category;
import com.pilipili.server.mapper.CategoryMapper;
import com.pilipili.server.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频分类 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
