package com.pilipili.business.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

@RestController("webCommentController")
@RequestMapping("/web/comment")
public class CommentController extends BaseController {


    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable String id) {
        IPage<CommentDto> pageData = commentService.paging(new Page(1, 10),
                new QueryWrapper<CommentDto>().eq("video_id", id).orderByDesc("created_at"));
        return ResponseDto.success(pageData);
    }

    @PostMapping("/add")
    public ResponseDto add(@RequestBody CommentDto commentDto) {
        //  保存验证
        ValidatorUtil.ValidResult validResult = ValidatorUtil.validateBean(commentDto);

        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }

        commentService.mySave(commentDto);
        return ResponseDto.success();
    }

}
