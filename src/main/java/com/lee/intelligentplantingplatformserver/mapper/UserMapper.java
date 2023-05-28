package com.lee.intelligentplantingplatformserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.intelligentplantingplatformserver.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description 用户持久层
 * @Author lee
 * @Date 2023/3/20 15:30
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
