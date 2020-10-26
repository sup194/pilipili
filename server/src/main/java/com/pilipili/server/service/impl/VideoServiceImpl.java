package com.pilipili.server.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.*;
import com.pilipili.server.enums.VideoStatusEnum;
import com.pilipili.server.mapper.VideoMapper;
import com.pilipili.server.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import com.pilipili.server.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private CommentService commentService;

    @Autowired
    private UserService userService;


    @Override
    public IPage<VideoDto> paging(Page page, String categoryId, String userId, String status, String order) {
        QueryWrapper<VideoDto> wrapper = new QueryWrapper<VideoDto>()
                .eq(categoryId != null, "category_id", categoryId)
                .eq(userId != null, "user_id", userId)
                .eq(status != null, "status", status)
                .orderByDesc(order != null, order);


        return videoMapper.selectVideoes(page,wrapper);
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

        String sign = (categoryDto.getId().equals("00000100")) ? "E" : "S";
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
        video.setStatus(VideoStatusEnum.REVIEW.getCode());
        video.setCreatedAt(new Date());
        video.setUpdatedAt(new Date());

        this.save(video);
    }

    /**
     * 查找某一课程，供web模块用，只能查已发布的
     * @param id
     * @return
     */
    @Override
    public VideoVo findVideoById(String id) {

        Video video = videoMapper.selectById(id);
        if (video == null || !VideoStatusEnum.PASS.getCode().equals(video.getStatus())) {
            return null;
        }
        video.setPlayback(video.getPlayback() + 1);
        VideoVo videoVo = CopyUtil.copy(video, VideoVo.class);

        //  查询分类
        List<CategoryDto> categories = videoCategoryService.listByVideoId(new QueryWrapper<CategoryDto>().eq("videoId", id));
        videoVo.setCategories(categories);

        //  查询评论
        List<Comment> commentList = commentService.list(Wrappers.<Comment>query().lambda().eq(Comment::getUserId, id));
        List<CommentDto> comments = new ArrayList<>();
        if (!CollectionUtil.isEmpty(commentList)) {
            for (Comment comment : commentList) {
                CommentDto commentDto = CopyUtil.copy(comment, CommentDto.class);
                comments.add(commentDto);
            }
        }

        // 查询用户
        User user = userService.getById(video.getUserId());
        UserDto userDto = CopyUtil.copy(user, UserDto.class);
        videoVo.setUserDto(userDto);


        videoVo.setComments(comments);

        return videoVo;
    }
}
