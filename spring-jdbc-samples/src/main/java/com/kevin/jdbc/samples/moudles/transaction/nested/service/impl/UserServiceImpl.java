package com.kevin.jdbc.samples.moudles.transaction.nested.service.impl;

import com.kevin.jdbc.samples.moudles.transaction.domain.entity.UserConfigEntity;
import com.kevin.jdbc.samples.moudles.transaction.domain.entity.UserEntity;
import com.kevin.jdbc.samples.moudles.transaction.nested.repository.UserRepository;
import com.kevin.jdbc.samples.moudles.transaction.nested.service.UserConfigService;
import com.kevin.jdbc.samples.moudles.transaction.nested.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyong
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserConfigService userConfigService;

  private final UserRepository userRepository;

  public UserServiceImpl(UserConfigService userConfigService, UserRepository userRepository) {
    this.userConfigService = userConfigService;
    this.userRepository = userRepository;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
  @Override
  public void save(UserEntity userEntity) {
    //用户信息
    userRepository.saveUser(userEntity);

    //用户配置
    UserConfigEntity userConfig = new UserConfigEntity();
    userConfigService.save(userConfig);
  }
}