package com.pilipili.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.entity.Comment;
import com.pilipili.server.entity.User;
import com.pilipili.server.mapper.CommentMapper;
import com.pilipili.server.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.service.UserService;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 视频评论 服务实现类
 * </p>
 *
 * @author sup194
 * @since 2020-10-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;

    @Override
    public IPage<CommentDto> paging(Page page, QueryWrapper<CommentDto> wrapper) {

        return commentMapper.selectByVId(page, wrapper);
    }

    @Override
    public void mySave(CommentDto commentDto) {

        String shortUuid = UuidUtil.getShortUuid();
        commentDto.setId(shortUuid);
        Comment comment = CopyUtil.copy(commentDto, Comment.class);
        comment.setCreatedAt(new Date());
        this.save(comment);

    }
}
