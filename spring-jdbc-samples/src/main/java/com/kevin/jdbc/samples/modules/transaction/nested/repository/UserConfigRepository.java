package com.kevin.jdbc.samples.modules.transaction.nested.repository;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.UserConfigEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangyong
 */
@Repository
public interface UserConfigRepository {


  void saveUserConfig(UserConfigEntity userConfig);
}
