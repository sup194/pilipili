package com.pilipili.server.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDto {

    /**
     * id
     */
    @NotNull(message = "分类id不能为空")
    private String id;

    /**
     * 父id
     */
    private String parent;

    /**
     * 名称
     */
    @NotNull(message = "分类名称不能为空")
    private String name;

    /**
     * 顺序
     */
    private Integer sort;
}
