package com.pilipili.server.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserVo implements Serializable {


    @NotNull(message = "用户ID不能为空")
    private String id;
    private String sign;
    private String avatar;
    @NotNull(message = "用户名不能为空")
    private String name;
}
