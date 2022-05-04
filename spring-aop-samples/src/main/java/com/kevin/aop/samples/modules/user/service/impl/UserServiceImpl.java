package com.kevin.aop.samples.modules.user.service.impl;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserEntity getByUserId(Integer userId) {

        Logger.getGlobal().info("【获取用户信息】,用户ID:" + userId);

        return new UserEntity(userId, "张三");
    }
}
