package com.kevin.jdbc.samples.moudles.user.service;

import com.kevin.jdbc.samples.moudles.user.repository.domain.entity.UserEntity;

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
