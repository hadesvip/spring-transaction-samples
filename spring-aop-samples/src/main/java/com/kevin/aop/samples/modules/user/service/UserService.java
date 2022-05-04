package com.kevin.aop.samples.modules.user.service;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public interface UserService {


    UserEntity getByUserId(Integer userId);
}
