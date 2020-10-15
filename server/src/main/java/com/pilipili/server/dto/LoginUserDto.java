package com.pilipili.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String role;

    private String email;

    private String name;

    private String gender;

    private String sign;

    private String avatar;

    private String token;

}
