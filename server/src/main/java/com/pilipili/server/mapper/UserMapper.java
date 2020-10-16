package com.pilipili.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.UserDto;
import com.pilipili.server.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
public interface UserMapper extends BaseMapper<User> {


    IPage<UserDto> paging(Page page, @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);

}
