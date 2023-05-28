package com.lee.intelligentplantingplatformserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.intelligentplantingplatformserver.mapper.AlarmRecordMapper;
import com.lee.intelligentplantingplatformserver.model.entity.AlarmRecord;
import com.lee.intelligentplantingplatformserver.service.AlarmRecordService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AlarmRecordServiceImpl
 * @Description 报警记录 Service层实现类
 * @Author lee
 * @Date 2023/4/6 15:42
 * @Version 1.0
 */
@Service
public class AlarmRecordServiceImpl extends ServiceImpl<AlarmRecordMapper, AlarmRecord> implements AlarmRecordService {
}
