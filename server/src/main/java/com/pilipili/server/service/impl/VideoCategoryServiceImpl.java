package com.pilipili.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Video_Category;
import com.pilipili.server.mapper.Video_CategoryMapper;
import com.pilipili.server.service.Video_CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 视频分类 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Service
public class VideoCategoryServiceImpl extends ServiceImpl<Video_CategoryMapper, Video_Category> implements Video_CategoryService {

    @Resource
    Video_CategoryMapper video_categoryMapper;


    @Override
    public IPage<VideoDto> QueryVideoByCategoryID(Page page, String category_id) {
        return video_categoryMapper.QueryVideoByCategoryID(page,category_id);
    }

    @Override
    public List<Category> QueryCategoryById(String video_id) {
        return video_categoryMapper.QueryCategoryById(video_id);
    }
}
