package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 视频
 * </p>
 *
 * @author sup
 * @since 2020-09-24
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
     * vod|阿里云vod
     */
    private String vod;

    /**
     * 修改时间
     */
    private Date updatedAt;

}
