package com.pilipili.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 视频 Mapper 接口
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Component
public interface VideoMapper extends BaseMapper<Video> {

    IPage<VideoDto> selectVideos(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}
