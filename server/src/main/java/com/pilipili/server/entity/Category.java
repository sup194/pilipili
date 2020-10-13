package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 视频分类
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("video_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 视频|video.id
     */
    private String videoId;

    /**
     * 分类|video.id
     */
    private String categoryId;

}
