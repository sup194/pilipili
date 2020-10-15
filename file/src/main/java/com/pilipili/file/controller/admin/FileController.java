package com.pilipili.file.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilipili.server.dto.PageDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/file")
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);
    public static final String BUSINESS_NAME = "文件";

    @Resource
    private FileService fileService;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        Page page = new Page(pageDto.getPage(), pageDto.getSize());
        Page pageData = fileService.page(page);
        return ResponseDto.success(pageData);
    }
}
