package com.pilipili.business.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("webCommentController")
@RequestMapping("/web/comment")
public class CommentController extends BaseController {


    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable String id) {
        IPage<CommentDto> pageData = commentService.paging(new Page(1, 10),
                new QueryWrapper<CommentDto>().eq("video_id", id).orderByDesc("created_at"));
        return ResponseDto.success(pageData);
    }

}
