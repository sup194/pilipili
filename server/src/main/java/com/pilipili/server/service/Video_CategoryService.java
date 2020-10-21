package com.pilipili.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Video;
import com.pilipili.server.entity.Video_Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 视频分类 服务类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
public interface Video_CategoryService extends IService<Video_Category> {

    IPage<VideoDto> QueryVideoByCategoryID(Page page, String category_id);

    List<Category> QueryCategoryById(String video_id);
}
