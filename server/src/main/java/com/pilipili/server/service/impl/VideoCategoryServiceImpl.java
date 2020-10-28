package com.pilipili.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.VideoCategory;
import com.pilipili.server.mapper.VideoCategoryMapper;
import com.pilipili.server.service.VideoCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 视频分类 服务实现类
 * </p>
 *
 * @author sup194
 * @since 2020-10-22
 */
@Service
public class VideoCategoryServiceImpl extends ServiceImpl<VideoCategoryMapper, VideoCategory> implements VideoCategoryService {

    @Resource
    private VideoCategoryMapper videoCategoryMapper;


    @Override
    public List<CategoryDto> listByVideoId(QueryWrapper<CategoryDto> wrapper) {
        return videoCategoryMapper.listByVideoId(wrapper);
    }

    @Override
    public IPage<VideoDto> QueryVideoByCategoryID(Page page, String category_id) {
        return videoCategoryMapper.QueryVideoByCategoryID(page,category_id);
    }

    @Override
    public List<Category> QueryCategoryById(String video_id) {
        return videoCategoryMapper.QueryCategoryById(video_id);
    }

}