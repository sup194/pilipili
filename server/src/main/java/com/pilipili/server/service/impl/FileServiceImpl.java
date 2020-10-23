package com.pilipili.server.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pilipili.server.dto.FileDto;
import com.pilipili.server.entity.File;
import com.pilipili.server.mapper.FileMapper;
import com.pilipili.server.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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

    /**
     * 保存，id有值时更新，无值时新增
     */
    @Override
    public void save(FileDto fileDto) {

        File file = CopyUtil.copy(fileDto, File.class);
        File fileDb = selectByKey(fileDto.getKey());
        if (fileDb == null) {
            this.insert(file);
        } else {
            fileDb.setShardIndex(fileDto.getShardIndex());
            this.update(fileDb);
        }
    }

    /**
     * 新增
     */
    private void insert(File file) {

        Date now = new Date();
        file.setCreatedAt(now);
        file.setUpdatedAt(now);
        file.setId(UuidUtil.getShortUuid());

        this.save(file);
    }

    /**
     * 更新
     */
    private void update(File file) {

        file.setUpdatedAt(new Date());

        this.updateById(file);
    }

}
