package com.pilipili.file.controller.admin;

import com.pilipili.server.dto.FileDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RequestMapping("/admin")
@RestController
public class UploadController {

    @Value("https://online-pilipili.oss-cn-guangzhou.aliyuncs.com/")
    private String FILE_DOMAIN;


    @Autowired
    private FileService fileService;


    @GetMapping("/check/{key}")
    public ResponseDto check(@PathVariable String key) {

        log.info("检查上传分片开始：{}", key);
        FileDto fileDto = fileService.findByKey(key);
        if (fileDto != null) {
            fileDto.setPath(FILE_DOMAIN + fileDto.getPath());
        }

        return ResponseDto.success(fileDto);
    }

}
