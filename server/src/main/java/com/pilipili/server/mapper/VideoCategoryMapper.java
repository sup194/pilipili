package com.pilipili.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.VideoCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.bcel.classfile.Constant;

import java.util.List;

/**
 * <p>
 * 视频分类 Mapper 接口
 * </p>
 *
 * @author sup194
 * @since 2020-10-22
 */
public interface VideoCategoryMapper extends BaseMapper<VideoCategory> {

    List<CategoryDto> listByVideoId(@Param(Constants.WRAPPER) QueryWrapper<CategoryDto> wrapper);

    IPage<VideoDto> QueryVideoByCategoryID(Page page, String category_id);

    List<Category> QueryCategoryById(String video_id);
}
