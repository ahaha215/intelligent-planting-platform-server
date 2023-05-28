package com.lee.intelligentplantingplatformserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.intelligentplantingplatformserver.model.entity.AlarmRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName AlarmRecordMapper
 * @Description 报警记录 Mapper层
 * @Author lee
 * @Date 2023/4/6 15:40
 * @Version 1.0
 */
@Mapper
public interface AlarmRecordMapper extends BaseMapper<AlarmRecord> {
}
