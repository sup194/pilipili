package com.pilipili.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Video;
import com.pilipili.server.entity.VideoCategory;
import com.pilipili.server.mapper.VideoMapper;
import com.pilipili.server.service.CategoryService;
import com.pilipili.server.service.VideoCategoryService;
import com.pilipili.server.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 视频 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoCategoryService videoCategoryService;

    @Autowired
    private CategoryService categoryService;



    public IPage<VideoDto> paging(Page page, String categoryId, String userId, String status, String order) {

        return videoMapper.selectHotStudyVideos(page, new QueryWrapper<VideoDto>()
                .eq("status", "P").orderByDesc("play_volume"));
    }

    @Override
    public IPage<VideoDto> paging(Page page, String status, String sign, String order) {

        IPage<VideoDto> videoDto = videoMapper.selectHotStudyVideos(page, new QueryWrapper<VideoDto>()
                .eq("sign", sign)
                .eq("status", "P")
                .orderByDesc("play_volume"));
        return videoDto;
    }


    @Override
    public void mySave(VideoDto videoDto) {

        List<CategoryDto> categories = videoDto.getCategories();
        CategoryDto categoryDto = categories.get(0);
        String uuid = UuidUtil.getShortUuid();

        Category category = categoryService.getById(categoryDto.getId());
        String sign = (category.getParent() == "00000100") ? "E" : "S";
        videoDto.setSign(sign);
        videoDto.setPlayback(0);

        for (CategoryDto dto : categories) {
            VideoCategory videoCategory = new VideoCategory();
            videoCategory.setId(UuidUtil.getShortUuid());
            videoCategory.setCategoryId(dto.getId());
            videoCategory.setVideoId(uuid);

            videoCategoryService.save(videoCategory);
        }


        videoDto.setId(uuid);
        Video video = CopyUtil.copy(videoDto, Video.class);
        this.save(video);
    }
}
