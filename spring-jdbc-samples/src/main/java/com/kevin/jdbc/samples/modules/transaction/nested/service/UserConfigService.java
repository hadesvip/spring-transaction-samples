package com.kevin.jdbc.samples.modules.transaction.nested.service;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.UserConfigEntity;

/**
 * @author wangyong
 */
public interface UserConfigService {

  void save(UserConfigEntity userConfig);

}
