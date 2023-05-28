package com.lee.intelligentplantingplatformserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.intelligentplantingplatformserver.mapper.UserMapper;
import com.lee.intelligentplantingplatformserver.model.entity.User;
import com.lee.intelligentplantingplatformserver.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 用户服务层实现类
 * @Author lee
 * @Date 2023/3/20 15:34
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
