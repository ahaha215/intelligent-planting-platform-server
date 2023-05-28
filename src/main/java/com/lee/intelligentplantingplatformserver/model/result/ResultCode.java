package com.lee.intelligentplantingplatformserver.model.result;

/**
 * @ClassName ResultCode
 * @Description 返回对象代码
 * @Author lee
 * @Date 2023/3/18 15:14
 * @Version 1.0
 */
public interface ResultCode {
    /**
     * 返回成功状态码
     */
    public static Integer SUCCESS = 20000;

    /**
     * 返回失败状态码
     */
    public static Integer ERROR = 20001;
}
