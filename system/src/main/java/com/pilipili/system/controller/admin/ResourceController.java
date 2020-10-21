package com.pilipili.system.controller.admin;

import com.pilipili.server.dto.ResourceDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.util.ValidatorUtil;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pilipili.server.service.ResourceService;
import com.pilipili.server.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 资源 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController {


    @Autowired
    private ResourceService resourceService;

    //    List列表查询
    @GetMapping(value = "/")
    public ResponseDto list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Resource> aPage = resourceService.page(new Page<>(current, pageSize));
        return ResponseDto.success(aPage);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
//    @PostMapping("/save")
//    public ResponseDto save(@RequestBody String jsonStr) {
//
////        抛出异常
//        // 保存校验
////        ValidatorUtil.require(jsonStr, "资源");
//
//        if (StringUtils.isEmpty(jsonStr)) {
//            throw new ValidatorException(jsonStr + "不能为空");
//        }
//        resourceService.saveJson(jsonStr);
//        return ResponseDto.success();
//    }

    /**
     * 删除
     */
    @PostMapping(value = "/delete/{id}")
    public ResponseDto delete(@PathVariable("id") String id) {
        resourceService.removeById(id);
        return ResponseDto.success();
    }

    /**
     * 资源树查询
     */
//    @GetMapping("/load-tree")
//    public ResponseDto loadTree() {
//        List<ResourceDto> resourceDtoList = resourceService.loadTree();
//        return ResponseDto.success(resourceDtoList);
//    }

}
