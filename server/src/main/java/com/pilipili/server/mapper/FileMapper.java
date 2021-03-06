package com.pilipili.server.mapper;

import com.pilipili.server.entity.File;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 文件 Mapper 接口
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Component
public interface FileMapper extends BaseMapper<File> {

    List<File> selectByKey(String key);
}
