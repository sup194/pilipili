package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 视频
 * </p>
 *
 * @author sup194
 * @since 2020-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("video")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
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
    private String image;

    /**
     * 状态|枚举[CourseStatusEnum]：REVIEW("R", "审核中"),PASS("P", "通过"),OVERRULE("O", "驳回")
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
    @NotBlank(message = "userId不能为空")
    private String userId;

    /**
     * vod|阿里云vod
     */
    private String vod;

    /**
     * 修改时间
     */
    private Date updatedAt;

    /**
     * 投稿视频url
     */
    private String url;

    /**
     * 标识|枚举[SignEnum]：STUDY("S", "学习"),ENTERTAINMENT("E", "娱乐")
     */
    private String sign;

    /**
     * 播放量
     */
    private Integer playback;

}
