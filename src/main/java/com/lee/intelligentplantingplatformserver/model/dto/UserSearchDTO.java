package com.lee.intelligentplantingplatformserver.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserSearchDTO
 * @Description 用户搜索 DTO
 * @Author lee
 * @Date 2023/3/31 16:23
 * @Version 1.0
 */
@Data
public class UserSearchDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    /**
     * 当前页码
     */
    private long current;

    /**
     * 每页条目数
     */
    private long limit;

    /**
     * 搜索类型
     */
    private String type;

    /**
     * 搜索内容
     */
    private String content;
}
