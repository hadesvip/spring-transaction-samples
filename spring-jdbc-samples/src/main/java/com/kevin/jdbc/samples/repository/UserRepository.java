package com.kevin.jdbc.samples.repository;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author kevin
 */
@Repository
public interface UserRepository {


    /**
     * @param user
     */
    void save(UserEntity user);


}
