package com.kevin.jdbc.samples.moudles.transaction.nested.repository;

import com.kevin.jdbc.samples.moudles.transaction.domain.entity.UserConfigEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangyong
 */
@Repository
public interface UserConfigRepository {


  void saveUserConfig(UserConfigEntity userConfig);
}
