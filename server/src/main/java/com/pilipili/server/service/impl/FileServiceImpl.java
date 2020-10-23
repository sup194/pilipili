package com.pilipili.server.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pilipili.server.dto.FileDto;
import com.pilipili.server.entity.File;
import com.pilipili.server.mapper.FileMapper;
import com.pilipili.server.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {


    public File selectByKey(String key) {

        List<File> list = this.list(new QueryWrapper<File>().eq("`key`", key));
        if (CollectionUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public FileDto findByKey(String key) {
        return CopyUtil.copy(selectByKey(key), FileDto.class);
    }
}
