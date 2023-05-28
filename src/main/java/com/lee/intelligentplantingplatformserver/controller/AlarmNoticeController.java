package com.lee.intelligentplantingplatformserver.controller;

import com.lee.intelligentplantingplatformserver.model.entity.AlarmRecord;
import com.lee.intelligentplantingplatformserver.model.result.R;
import com.lee.intelligentplantingplatformserver.service.AlarmRecordService;
import com.lee.intelligentplantingplatformserver.util.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @ClassName AlarmNoticeController
 * @Description 警告通知控制层
 * @Author lee
 * @Date 2023/4/11 21:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/alarmNotice")
@CrossOrigin
@Slf4j
public class AlarmNoticeController {

    @Autowired
    private AlarmRecordService alarmRecordService;

    /**
     * 发送邮箱，并记录
     * @param type
     * @return
     */
    @PostMapping("/alarmNotice")
    public R alarmNotice(String type) {
        log.info("alarmType :" + type);

        try {
            // 发送邮箱通知用户
            String email = "1763318259@qq.com";
            String text = "平台检测到您的种植地可能存在"+ type +"风险，为避免风险发生，请及时查看处理！";
            String title = "基于物联网的智能感知与控制平台--⚠️警告";
            MailUtils.sendMail(email,text,title);

            // 将报警信息存储到报警记录中
            AlarmRecord alarmRecord = new AlarmRecord();
            alarmRecord.setTime(new Date());
            alarmRecord.setType(type);
            alarmRecord.setLevel("高");
            alarmRecord.setDescription("危险");
            alarmRecord.setIsHandle("未处理");
            alarmRecordService.save(alarmRecord);
        } catch (Exception e){
            return R.error().message("发送警告邮件失败！");
        }
        return R.success();
    }
}
