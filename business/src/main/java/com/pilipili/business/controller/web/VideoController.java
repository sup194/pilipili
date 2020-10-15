package com.pilipili.business.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 视频 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-26
 */
@RestController("webVideoController")
@RequestMapping("/web/video")
public class VideoController extends BaseController {

    /**
     * 列表查询，查询最新的6个视频
     * @return
     */
    @GetMapping("/listNew")
    public ResponseDto listNew(){
        Page page = new Page(1, 4);
        Page pageDta = videoService.page(page, new QueryWrapper<Video>()
                .eq("status", "P").orderByDesc("created_at"));
        return ResponseDto.success(pageDta);
    }

    @GetMapping("/hotList")
    public ResponseDto hotList() {
        Page page = new Page(1, 6);
        IPage<VideoDto> pageData = videoService.paging(page,
                null, null, "P", "play_volume");
        return ResponseDto.success(pageData);
    }

    @GetMapping("/hotStudyList")
    public ResponseDto hotStudyList() {
        Page page = new Page(1, 10);
        IPage<VideoDto> pageData = videoService.paging(page,
                null, null, "P", "play_volume");
        return ResponseDto.success(pageData);
    }


}
