package com.pilipili.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.VideoCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 视频分类 服务类
 * </p>
 *
 * @author sup194
 * @since 2020-10-22
 */
public interface VideoCategoryService extends IService<VideoCategory> {


    List<CategoryDto> listByVideoId(QueryWrapper<CategoryDto> wrapper);

    IPage<VideoDto> QueryVideoByCategoryID(Page page, String category_id);

    List<Category> QueryCategoryById(String video_id);
}