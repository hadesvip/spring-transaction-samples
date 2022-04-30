package com.kevin.mybatis.samples.modules.user.service;

import com.kevin.mybatis.samples.modules.user.domain.entity.UserEntity;

/**
 * @author kevin
 */
public interface UserService {


    void save(UserEntity userEntity);


    UserEntity queryByUserNo(String userNo);


}
