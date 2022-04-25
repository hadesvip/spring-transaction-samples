package com.kevin.jdbc.samples.service.impl;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;
import com.kevin.jdbc.samples.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kevin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(UserEntity user) {

    }
}
