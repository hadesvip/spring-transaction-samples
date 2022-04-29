package com.kevin.jdbc.samples.modulars.transaction.nested.repository;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.UserConfigEntity;
import org.springframework.stereotype.Repository;

/**
 * @author wangyong
 */
@Repository
public interface UserConfigRepository {


  void saveUserConfig(UserConfigEntity userConfig);
}
