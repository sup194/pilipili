package com.pilipili.server.dto;

import lombok.Data;

@Data
public class Video_CategoryDto {

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
