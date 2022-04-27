package com.kevin.jdbc.samples.moudles.transaction.nested.repository;

import com.kevin.jdbc.samples.moudles.transaction.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangyong
 */
@Repository
public interface UserRepository {

  void saveUser(UserEntity userEntity);
}
