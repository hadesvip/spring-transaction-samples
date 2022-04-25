package com.kevin.jdbc.samples.service;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author kevin
 */
@Service
public interface UserService {

    /**
     *
     * @param user
     */
    void save(UserEntity user);

}
