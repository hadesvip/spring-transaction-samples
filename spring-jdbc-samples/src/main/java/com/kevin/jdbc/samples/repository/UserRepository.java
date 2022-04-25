package com.kevin.jdbc.samples.repository;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kevin
 */
public interface UserRepository {


    /**
     * @param user
     */
    void save(UserEntity user);


}
