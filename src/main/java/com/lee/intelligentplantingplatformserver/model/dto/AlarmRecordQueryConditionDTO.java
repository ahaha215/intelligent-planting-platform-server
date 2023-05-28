package com.lee.intelligentplantingplatformserver.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName AlarmRecordQueryConditionDTO
 * @Description 报警记录条件查询对象 DTO
 * @Author lee
 * @Date 2023/4/6 19:15
 * @Version 1.0
 */
@Data
public class AlarmRecordQueryConditionDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    /**
     * 当前页
     */
    private long current;

    /**
     * 每页数量
     */
    private long limit;

    /**
     * 查询类型
     * 分为已处理，未处理，全部
     */
    private String type;

    /**
     * 查询开始时间
     */
    private Date beginTime;

    /**
     * 查询结束时间
     */
    private Date endTime;
}
