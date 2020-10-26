package com.pilipili.business.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Video;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.util.ValidatorUtil;
import com.pilipili.server.vo.VideoVo;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDto listNew() {
        Page page = new Page(1, 4);
        IPage<VideoDto> pageData = videoService.paging(page, null, null, "P", "created_at");
        return ResponseDto.success(pageData);
    }

    @GetMapping("/hotList")
    public ResponseDto hotList() {
        Page page = new Page(1, 6);
        IPage<VideoDto> pageData = videoService.paging(page,
                null, null, "P", "playback");
        return ResponseDto.success(pageData);
    }

    @GetMapping("/newStudyList")
    public ResponseDto newStudyList() {
        Page page = new Page(1, 8);

        Page pageData = videoService.page(page, new QueryWrapper<Video>().eq("sign", "S")
                .eq("status", "P")
                .orderByDesc("created_at"));
        return ResponseDto.success(pageData);
    }

    @GetMapping("/newEntertainmentList")
    public ResponseDto newEntertainmentList() {
        Page page = new Page(1, 8);

        Page pageData = videoService.page(page, new QueryWrapper<Video>().eq("sign", "E")
                .eq("status", "P")
                .orderByDesc("created_at"));
        return ResponseDto.success(pageData);
    }

    @GetMapping("/hotStudyList")
    public ResponseDto hotStudyList() {
        Page page = new Page(1, 10);
        Page pageData = videoService.page(page, new QueryWrapper<Video>().eq("sign", "E")
                .eq("status", "P")
                .orderByDesc("playback"));
        return ResponseDto.success(pageData);
    }

    @PostMapping("/contribution")
    public ResponseDto contribution(@RequestBody VideoDto videoDto) {

        System.out.println(videoDto);
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(videoDto);
        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }
        videoService.mySave(videoDto);

        return ResponseDto.success();
    }

    @GetMapping("/detail/{id}")
    public ResponseDto findCourse(@PathVariable String id) {
        VideoVo videoVo = videoService.findVideoById(id);

        return ResponseDto.success(videoVo);
    }



}
