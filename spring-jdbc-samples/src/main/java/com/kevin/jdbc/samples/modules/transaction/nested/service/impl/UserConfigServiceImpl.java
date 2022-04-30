package com.kevin.jdbc.samples.modules.transaction.nested.service.impl;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.UserConfigEntity;
import com.kevin.jdbc.samples.modules.transaction.nested.repository.UserConfigRepository;
import com.kevin.jdbc.samples.modules.transaction.nested.service.UserConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyong
 */
@Service
public class UserConfigServiceImpl implements UserConfigService {

  private final UserConfigRepository userConfigRepository;

  public UserConfigServiceImpl(UserConfigRepository userConfigRepository) {
    this.userConfigRepository = userConfigRepository;
  }


  @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
  @Override
  public void save(UserConfigEntity userConfig) {
    userConfigRepository.saveUserConfig(userConfig);
  }
}
