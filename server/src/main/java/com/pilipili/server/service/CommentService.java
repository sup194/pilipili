package com.pilipili.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 视频评论 服务类
 * </p>
 *
 * @author sup194
 * @since 2020-10-20
 */
public interface CommentService extends IService<Comment> {

    IPage<CommentDto> paging(Page page, QueryWrapper<CommentDto> wrapper);

    void mySave(CommentDto commentDto);
}
