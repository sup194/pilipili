package com.pilipili.business.controller.admin;

import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.Video_Category;
import com.pilipili.server.exception.ValidatorException;
import com.pilipili.server.service.CategoryService;
import com.pilipili.server.service.Video_CategoryService;
import com.pilipili.server.util.CopyUtil;
import com.pilipili.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 视频分类 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-26
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;
    ValidatorUtil.ValidResult validResult;
    @GetMapping("/list")
    public ResponseDto List(){
        log.info("展示category(分类)列表");
//        List<Video_Category> videoCategoryList = categoryService.showlist();
        List<Category> categoryList = categoryService.List();
        return ResponseDto.success(categoryList);
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CategoryDto categoryDto){
        log.info("保存分类");
        validResult = ValidatorUtil.validateBean(categoryDto);
        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }
        Category category = CopyUtil.copy(categoryDto, Category.class);
        categoryService.save(category);
        return ResponseDto.success();
    }

    @PostMapping("/update")
    public ResponseDto update(@RequestBody CategoryDto categoryDto){
        log.info("更新分类");
        validResult = ValidatorUtil.validateBean(categoryDto);
        if (validResult.hasErrors()) {
            throw new ValidatorException(validResult.getErrors());
        }
        Category category = CopyUtil.copy(categoryDto, Category.class);
        categoryService.updateById(category);

        return ResponseDto.success();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        log.info("通过id删除");


        return ResponseDto.success();
    }






}
