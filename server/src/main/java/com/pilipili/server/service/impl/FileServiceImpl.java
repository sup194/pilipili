package com.pilipili.server.service.impl;

import com.pilipili.server.entity.File;
import com.pilipili.server.mapper.FileMapper;
import com.pilipili.server.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
