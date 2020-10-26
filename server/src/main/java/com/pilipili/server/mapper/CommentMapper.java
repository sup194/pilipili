package com.pilipili.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 视频评论 Mapper 接口
 * </p>
 *
 * @author sup194
 * @since 2020-10-20
 */
public interface CommentMapper extends BaseMapper<Comment> {

    IPage<CommentDto> selectByVId(Page page, @Param(Constants.WRAPPER) QueryWrapper<CommentDto> wrapper);
}
