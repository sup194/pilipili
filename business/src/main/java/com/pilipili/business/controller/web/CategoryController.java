package com.pilipili.business.controller.web;

import com.pilipili.server.dto.ResponseDto;
<<<<<<< HEAD
import com.pilipili.server.entity.Video_Category;
=======
import com.pilipili.server.entity.Category;
import com.pilipili.server.entity.VideoCategory;
>>>>>>> master
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 视频分类 前端控制器
 * </p>
 *
 * @author sup
 * @since 2020-09-26
 */
@RestController("webCategoryController")
@RequestMapping("/web/category")
public class CategoryController extends BaseController {


    @GetMapping("/all")
    public ResponseDto all(){
        List<Video_Category> videoCategoryList = videoCategoryService.list();
        return ResponseDto.success(videoCategoryList);
    }

}
