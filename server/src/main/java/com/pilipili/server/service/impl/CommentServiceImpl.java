package com.pilipili.server.service.impl;

import com.pilipili.server.entity.Comment;
import com.pilipili.server.mapper.CommentMapper;
import com.pilipili.server.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
