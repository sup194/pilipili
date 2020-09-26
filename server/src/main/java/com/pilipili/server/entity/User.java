package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 用户
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * 密码
     */
    private String password;

}
