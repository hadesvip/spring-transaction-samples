package com.kevin.jdbc.samples.modules.transaction.nested.repository;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangyong
 */
@Repository
public interface UserRepository {

  void saveUser(UserEntity userEntity);
}
