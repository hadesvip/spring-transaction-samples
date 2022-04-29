package com.kevin.jdbc.samples.modulars.user.service;

import com.kevin.jdbc.samples.modulars.user.repository.domain.entity.UserEntity;

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
