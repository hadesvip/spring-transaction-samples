package com.kevin.jdbc.samples.modules.transaction.nested.service;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.UserEntity;

/**
 * @author wangyong
 */
public interface UserService {

  void save(UserEntity userEntity);

}
