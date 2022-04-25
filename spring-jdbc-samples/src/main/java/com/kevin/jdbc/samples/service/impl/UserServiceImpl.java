package com.kevin.jdbc.samples.service.impl;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;
import com.kevin.jdbc.samples.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kevin
 */
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;


    public void save(UserEntity user) {

    }
}
