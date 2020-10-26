package com.pilipili.server.dto;

import lombok.Data;

@Data
public class UserDto {

    /**
     * id
     */
    private String id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用途|枚举[GenderEnum]：MAlE("M","男"),FEMALE("F","女"),SECRET("S","保密")
     */
    private String gender;

    /**
     * 我的签名
     */
    private String sign;

    /**
     * 头像
     */
    private String avatar;

}
