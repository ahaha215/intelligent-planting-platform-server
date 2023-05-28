package com.lee.intelligentplantingplatformserver.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageVO
 * @Description 分页VO
 * @Author lee
 * @Date 2023/3/30 15:10
 * @Version 1.0
 */
@Data
public class PageVO implements Serializable {
    private static final long serialVersionUID = 1l;

    /**
     * 总数
     */
    private long total;

    /**
     * 页码数
     */
    private long pages;

    /**
     * 是否有前页
     */
    private boolean hasPrevious;

    /**
     * 是否有后页
     */
    private boolean hasNext;

    /**
     * 查询数据
     */
    private List list;
}
