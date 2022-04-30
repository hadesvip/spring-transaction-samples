package com.kevin.jdbc.samples.modules.transaction.service.impl;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.TransactionEntity;
import com.kevin.jdbc.samples.modules.transaction.repository.TransactionRepository;
import com.kevin.jdbc.samples.modules.transaction.service.PropagationRequiresNewBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kevin
 */
@Service
public class PropagationNewBServiceImpl implements PropagationRequiresNewBService {


  private final TransactionRepository transactionRepository;

  public PropagationNewBServiceImpl(
      TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  @Override
  public void payB(TransactionEntity transactionEntity) {
    transactionRepository.save(transactionEntity);

    //一些业务逻辑
  }
}
