package com.pilipili.server.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class CommentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String Id;

    /**
     * 用户|user.id
     */
    @NotNull(message = "用户ID不能为空")
    private String userId;

    /**
     * 视频|video.id
     */
    @NotNull(message = "视频ID不能为空")
    private String videoId;

    /**
     * 评论内容
     */
    @NotNull(message = "视频内容不能为空")
    private String content;

    private UserDto userDto;
}
