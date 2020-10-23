package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 视频播放
 * </p>
 *
 * @author sup194
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("video_playback")
public class VideoPlayback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 视频ID
     */
    private String videoId;

    /**
     * 播放量
     */
    private Integer playVolume;

}
