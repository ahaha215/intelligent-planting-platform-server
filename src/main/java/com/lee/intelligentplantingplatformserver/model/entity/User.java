package com.lee.intelligentplantingplatformserver.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author lee
 * @Date 2023/3/20 15:03
 * @Version 1.0
 */
@TableName("t_user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1l;

    /**
     * 用户ID
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话号
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户头像地址
     */
    private String avatar;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 逻辑删除标识位
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
