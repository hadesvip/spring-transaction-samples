package com.kevin.jdbc.samples.modulars.transaction.nested.service;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.UserEntity;

/**
 * @author wangyong
 */
public interface UserService {

  void save(UserEntity userEntity);

}
