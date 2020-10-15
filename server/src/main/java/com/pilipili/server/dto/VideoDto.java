package com.pilipili.server.dto;

import com.pilipili.server.entity.Video;
import lombok.Data;

@Data
public class VideoDto extends Video {

    private Long play_volume;

}
