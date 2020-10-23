package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 视频评论
 * </p>
 *
 * @author sup194
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 用户|user.id
     */
    private String userId;

    /**
     * 视频|video.id
     */
    private String videoId;

    /**
     * 评论内容
     */
    private String content;

}
