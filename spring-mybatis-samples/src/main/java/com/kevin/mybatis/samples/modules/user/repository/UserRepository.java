package com.kevin.mybatis.samples.modules.user.repository;

import com.kevin.mybatis.samples.modules.user.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author kevin
 */
@Repository
public interface UserRepository {


  int save(UserEntity userEntity);


  UserEntity queryByUserNo(@Param("userNo")String userNo);









}
