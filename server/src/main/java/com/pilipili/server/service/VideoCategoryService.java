package com.pilipili.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pilipili.server.dto.CategoryDto;
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
}
