package com.pilipili.server.dto;

import lombok.Data;

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
    private String userId;

    /**
     * 视频|video.id
     */
    private String videoId;

    /**
     * 评论内容
     */
    private String content;

    private UserDto userDto;
}
