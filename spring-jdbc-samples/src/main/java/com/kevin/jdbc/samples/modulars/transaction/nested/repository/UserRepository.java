package com.kevin.jdbc.samples.modulars.transaction.nested.repository;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangyong
 */
@Repository
public interface UserRepository {

  void saveUser(UserEntity userEntity);
}
