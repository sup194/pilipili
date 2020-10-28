package com.pilipili.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String UserId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

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

    /**
     * 角色
     */
    private String role;
    /**
     * 密码
     */
    private String password;

}
