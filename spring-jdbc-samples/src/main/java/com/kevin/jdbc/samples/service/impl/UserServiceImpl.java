package com.kevin.jdbc.samples.service.impl;

import com.kevin.jdbc.samples.repository.domain.entity.UserEntity;
import com.kevin.jdbc.samples.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Logger;

/**
 * @author kevin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final JdbcTemplate jdbcTemplate;


    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(UserEntity user) {
        Logger.getGlobal().info("【保存用户信息】用户信息:" + user);
        int rowNum =
                jdbcTemplate.update("insert into t_user(user_id , user_name, phone_number, email) value(?,?,?,?)",
                        new Object[]{user.getUserId(), user.getUserName(), user.getPhoneNumber(), user.getEmail()},
                        new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
        Logger.getGlobal().info("影响行数:" + rowNum);

    }

    @Override
    public UserEntity queryByUserId(String userId) {
        Logger.getGlobal().info("【查询用户信息】用户ID:" + userId);
        UserEntity queryRt =
                jdbcTemplate.query("select user_id , user_name, phone_number, email from t_user where user_id = ? ",
                        rs -> {
                            UserEntity userEntity = null;
                            if (rs.next()) {
                                userEntity = new UserEntity();
                                userEntity.setUserId(rs.getString("user_id"));
                                userEntity.setUserName(rs.getString("user_name"));
                                userEntity.setPhoneNumber(rs.getString("phone_number"));
                                userEntity.setEmail(rs.getString("email"));
                            }
                            return userEntity;
                        }, userId);
        return queryRt;
    }


}
