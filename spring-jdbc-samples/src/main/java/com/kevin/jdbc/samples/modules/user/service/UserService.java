package com.kevin.jdbc.samples.modules.user.service;

import com.kevin.jdbc.samples.modules.user.repository.domain.entity.UserEntity;

/**
 * @author kevin
 */
public interface UserService {

    /**
     *
     * @param user
     */
    void save(UserEntity user);


    UserEntity queryByUserId(String userId);

}
