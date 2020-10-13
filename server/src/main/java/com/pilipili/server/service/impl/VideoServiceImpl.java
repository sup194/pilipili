package com.pilipili.server.service.impl;

import com.pilipili.server.entity.Video;
import com.pilipili.server.mapper.VideoMapper;
import com.pilipili.server.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
