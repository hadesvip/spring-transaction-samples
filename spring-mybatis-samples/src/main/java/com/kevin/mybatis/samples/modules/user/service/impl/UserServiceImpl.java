package com.kevin.mybatis.samples.modules.user.service.impl;

import com.kevin.mybatis.samples.modules.user.domain.entity.UserEntity;
import com.kevin.mybatis.samples.modules.user.repository.UserRepository;
import com.kevin.mybatis.samples.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kevin
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;


    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);

    }

    @Override
    public UserEntity queryByUserNo(String userNo) {
        return userRepository.queryByUserNo(userNo);
    }
}
