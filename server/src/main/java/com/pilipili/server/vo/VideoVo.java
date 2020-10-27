package com.pilipili.server.vo;

import com.pilipili.server.dto.CategoryDto;
import com.pilipili.server.dto.CommentDto;
import com.pilipili.server.dto.UserDto;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class VideoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 标题
     */
    @NotNull(message = "标题不能为空")
    @Length(min = 1, max = 50, message = "标题长度错误")
    private String name;

    /**
     * 概述
     */
    private String summary;

    /**
     * 时长|单位秒
     */
    private Integer time;

    /**
     * 封面
     */
    @NotNull(message = "封面不能为空")
    private String image;

    /**
     * 状态|枚举[VideoStatusEnum]：REVIEW("R", "审核中"),PASS("P", "通过"),OVERRULE("O", "驳回")
     */
    private String status;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * vod|阿里云vod
     */
    private String vod;

    /**
     * 修改时间
     */
    private Date updatedAt;

    /**
     * 视频地址
     */
    @Length(min = 1, max = 200, message = "url长度错误")
    private String url;


    @Valid
    private List<CategoryDto> categories;

    /**
     * 标识|枚举[SignEnum]：STUDY("S", "学习"),ENTERTAINMENT("E", "娱乐")
     */
    private String sign;

    /**
     * 播放量
     */
    private Integer playback;


    private UserDto userDto;
}
