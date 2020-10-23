package com.pilipili.server.service.impl;

import com.pilipili.server.entity.VideoCategory;
import com.pilipili.server.mapper.VideoCategoryMapper;
import com.pilipili.server.service.VideoCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
