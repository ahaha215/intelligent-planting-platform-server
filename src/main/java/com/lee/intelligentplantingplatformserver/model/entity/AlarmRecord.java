package com.lee.intelligentplantingplatformserver.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName AlarmRecord
 * @Description 报警记录 实体类
 * @Author lee
 * @Date 2023/4/6 15:11
 * @Version 1.0
 */
@TableName("t_alarm_record")
@Data
public class AlarmRecord implements Serializable {
    private static final long serialVersionUID = 1l;

    /**
     * id号
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 报警时间
     */
    private Date time;

    /**
     * 报警类型
     */
    private String type;

    /**
     * 报警说明
     */
    private String description;

    /**
     * 报警级别
     */
    private String level;

    /**
     * 是否处理
     */
    private String isHandle;

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
