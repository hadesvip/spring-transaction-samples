package com.kevin.jdbc.samples.modules.transaction.service.impl;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.TransactionEntity;
import com.kevin.jdbc.samples.modules.transaction.service.PropagationRequiredASerivce;
import com.kevin.jdbc.samples.modules.transaction.service.PropagationRequiredBSerivce;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyong
 */
@Service
public class PropagationRequiredAServiceImpl implements PropagationRequiredASerivce {

  private final PropagationRequiredBSerivce propagationRequiredBSerivce;

  public PropagationRequiredAServiceImpl(
      PropagationRequiredBSerivce propagationRequiredBSerivce) {
    this.propagationRequiredBSerivce = propagationRequiredBSerivce;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void payA() {
    TransactionEntity transactionEntity = new TransactionEntity();
    transactionEntity.setTransactionId(UUID.randomUUID().toString());
    transactionEntity.setName("测试");
    propagationRequiredBSerivce.payB(transactionEntity);

    //其他逻辑
  }
}
