package com.kevin.jdbc.samples.modules.transaction.service;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.TransactionEntity;

/**
 * @author kevin
 */
public interface PropagationRequiresNewBService {

  void payB(TransactionEntity transactionEntity);

}
