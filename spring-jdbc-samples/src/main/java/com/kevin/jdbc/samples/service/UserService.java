package com.kevin.jdbc.samples.service;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;

/**
 * @author kevin
 */
public interface UserService {

    /**
     *
     * @param user
     */
    void save(UserEntity user);

}
