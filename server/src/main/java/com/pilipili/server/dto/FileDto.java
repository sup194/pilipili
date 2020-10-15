package com.pilipili.server.dto;

import com.pilipili.server.entity.File;
import lombok.Data;

@Data
public class FileDto extends File {

    private Integer shardIndex;

    private Integer shardSize;

    private Integer shardTotal;

    private String key;

    /**
     * base64
     */
    private String shard;

}
