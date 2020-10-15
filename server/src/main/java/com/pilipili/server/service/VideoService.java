package com.pilipili.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 视频 服务类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
public interface VideoService extends IService<Video> {

    IPage<VideoDto> paging(Page page, String categoryId, String userId, String status, String order);
}
