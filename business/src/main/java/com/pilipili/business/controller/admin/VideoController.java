package com.pilipili.business.controller.admin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.dto.VideoDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Video;
import com.pilipili.server.entity.Video_Category;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.service.CategoryService;
import com.pilipili.server.service.VideoService;
import com.pilipili.server.service.Video_CategoryService;
import com.pilipili.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 视频 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-26
 */
@Slf4j
@RestController
@RequestMapping("/admin/video")
public class VideoController {

    @Resource
    VideoService videoService;
    @Resource
    Video_CategoryService video_categoryService;



//    查找分类下所有的视频
    @PostMapping("/QueryVideoByCategoryID/{category_id}")
    public ResponseDto QueryVideoByCategoryID(@PathVariable String category_id){

        if (category_id.isEmpty()){
            throw new ValidatorException("分类ID不能为空");
        }
        Page page = new Page(1, 4);

        IPage<VideoDto> videoDtoIPage = video_categoryService.QueryVideoByCategoryID(page,category_id);
        return ResponseDto.success(videoDtoIPage);
    }


//    查找此ID视频的所有分类
    @PostMapping("/QueryCategoryById/{video_id}")
    public ResponseDto QueryCategoryById(@PathVariable String video_id){

        if (video_id.isEmpty()){
            throw new ValidatorException("视频ID不能为空");
        }

        List<Category> videoList = video_categoryService.QueryCategoryById(video_id);

        return ResponseDto.success(videoList);
    }

//    添加视频
//    视频审核(修改)
    @PostMapping("/saveVideo")
    public ResponseDto saveVideo(VideoDto videoDto){
        log.info("添加视频");
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(videoDto);

        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }

        videoService.saveOrUpdate(videoDto);
        return ResponseDto.success();
    }

//    查询视频审核状态接口
    @PostMapping("/QueryVideoStatus/{status}")
    public ResponseDto QueryVideoStatus(@PathVariable String status) {

        Page page = new Page(1,4);

        Page<Video> videoPage = videoService.page(page,new QueryWrapper<Video>()
        .eq("status",status).orderByAsc("created_at")
        );
        return ResponseDto.success(videoPage);

    }



// 查询关于此用户ID的视频的所有信息
    @PostMapping("/QueryVideosByUserId/{user_id}")
    public ResponseDto QueryVideosByUserId(@PathVariable String user_id){

        Page page = new Page(1, 4);

        Page pageDta = videoService.page(page, new QueryWrapper<Video>()
        .eq("user_id",user_id).orderByAsc("created_at")
        );

        return  ResponseDto.success(pageDta);
    }

//    通过ID删除视频
    @DeleteMapping("/Delete/{id}")
    public ResponseDto DeleteVideo(@PathVariable String id){
//        通过ID删除视频
        videoService.removeById(id);
        return ResponseDto.success();
    }





}
