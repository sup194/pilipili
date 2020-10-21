package com.pilipili.server.dto;

import com.pilipili.server.entity.Video;
import lombok.Data;

@Data
public class VideoDto extends Video {

    private Long play_volume;

    /**
     * 分类|video.id
     */
    private String categoryId;

    /*
    驳回理由
    Grounds for refusal.
     */


}
