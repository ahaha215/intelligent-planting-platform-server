package com.lee.intelligentplantingplatformserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.intelligentplantingplatformserver.model.dto.AlarmRecordQueryConditionDTO;
import com.lee.intelligentplantingplatformserver.model.entity.AlarmRecord;
import com.lee.intelligentplantingplatformserver.model.result.R;
import com.lee.intelligentplantingplatformserver.model.vo.PageVO;
import com.lee.intelligentplantingplatformserver.service.AlarmRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName AlarmRecordController
 * @Description 报警记录控制层
 * @Author lee
 * @Date 2023/4/6 15:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/alarmRecord")
@CrossOrigin
@Slf4j
public class AlarmRecordController {
    @Autowired
    private AlarmRecordService alarmRecordService;

    /**
     * 保存报警记录
     * @param alarmRecord
     * @return
     */
    @PostMapping("/saveRecord")
    public R saveRecord(@RequestBody AlarmRecord alarmRecord){
        alarmRecord.setTime(new Date());
        alarmRecord.setIsHandle("未处理");
        boolean flag = alarmRecordService.save(alarmRecord);
        if (flag){
            return R.success();
        }
        return R.error().message("报警记录保存失败！");
    }

    /**
     * 按照报警id删除报警记录
     * @param recordId
     * @return
     */
    @DeleteMapping("/deleteRecord/{recordId}")
    private R deleteRecord(@PathVariable("recordId") String recordId){
        boolean flag = alarmRecordService.removeById(recordId);
        if (flag){
            return R.success();
        }
        return R.error().message("报警记录删除失败！");
    }

    /**
     * 处理报警记录
     * @param alarmRecord
     * @return
     */
    @PostMapping("/handleRecord")
    public R handleRecord(@RequestBody AlarmRecord alarmRecord){
        boolean flag = alarmRecordService.updateById(alarmRecord);
        if (flag){
            return R.success();
        }
        return R.error().message("报警记录处理失败！");
    }

    /**
     * 分页按条件查询报警记录
     * @param alarmRecordQueryConditionDTO
     * @return
     */
    @PostMapping("/pageAlarmRecordListByCondition")
    public R pageAlarmRecordListByCondition(@RequestBody AlarmRecordQueryConditionDTO alarmRecordQueryConditionDTO){
        log.info("alarmRecordQueryCondition:" + alarmRecordQueryConditionDTO);
        // 获取前端参数
        long current = alarmRecordQueryConditionDTO.getCurrent();
        long limit = alarmRecordQueryConditionDTO.getLimit();
        String type = alarmRecordQueryConditionDTO.getType();
        Date beginTime = alarmRecordQueryConditionDTO.getBeginTime();
        Date endTime = alarmRecordQueryConditionDTO.getEndTime();

        Page<AlarmRecord> page = new Page<>(current,limit);

        QueryWrapper<AlarmRecord> queryWrapper = new QueryWrapper<>();

        // 拼接查询条件
        if (type != "" && type != null){
            queryWrapper.eq("is_handle",type);
        }
        if (beginTime != null && endTime!= null){
            queryWrapper.between("gmt_create",beginTime,endTime);
        }

        Page<AlarmRecord> alarmRecordPage = alarmRecordService.page(page, queryWrapper);
        if (alarmRecordPage != null){
            PageVO pageVO = new PageVO();
            pageVO.setTotal(alarmRecordPage.getTotal());
            pageVO.setPages(alarmRecordPage.getPages());
            pageVO.setHasPrevious(alarmRecordPage.hasPrevious());
            pageVO.setHasNext(alarmRecordPage.hasNext());
            pageVO.setList(alarmRecordPage.getRecords());

            return R.success()
                    .data("alarmRecordPageVO",pageVO);
        }
        return R.error().message("报警记录查询失败！");
    }
}
