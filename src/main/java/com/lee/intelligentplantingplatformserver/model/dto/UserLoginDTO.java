package com.lee.intelligentplantingplatformserver.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserLoginDTO
 * @Description 用户登录DTO
 * @Author lee
 * @Date 2023/3/20 15:50
 * @Version 1.0
 */
@Data
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;
}
