package com.pilipili.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

<<<<<<< HEAD
    private String role;

=======
>>>>>>> zengx1n
    private String email;

    private String name;

    private String gender;

    private String sign;

    private String avatar;

    private String token;

}
