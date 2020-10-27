package com.pilipili.server.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author sup
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */

    private String id;

    /**
     * 角色
     */
    @NotBlank(message = "角色不能为空")
    private String name;

    /**
     * 描述
     */
    @NotBlank(message = "描述填写 1 ~ 100个字之间 ")
    @TableField("`desc`")
    private String desc;

}