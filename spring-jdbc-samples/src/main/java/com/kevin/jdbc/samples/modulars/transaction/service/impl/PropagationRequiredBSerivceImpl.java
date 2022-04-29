package com.kevin.jdbc.samples.modulars.transaction.service.impl;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.TransactionEntity;
import com.kevin.jdbc.samples.modulars.transaction.repository.TransactionRepository;
import com.kevin.jdbc.samples.modulars.transaction.service.PropagationRequiredBSerivce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangyong
 */
@Service
public class PropagationRequiredBSerivceImpl implements PropagationRequiredBSerivce {

  private final TransactionRepository transactionRepository;

  public PropagationRequiredBSerivceImpl(
      TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }


  @Transactional(rollbackFor = Exception.class)
  @Override
  public void payB(TransactionEntity transaction) {
    //执行逻辑

    //
    transactionRepository.save(transaction);
  }
}
