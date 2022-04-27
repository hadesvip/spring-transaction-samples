package com.kevin.jdbc.samples.moudles.transaction.service;

import com.kevin.jdbc.samples.moudles.transaction.domain.entity.TransactionEntity;

/**
 * @author kevin
 */
public interface PropagationRequiresNewBService {

  void payB(TransactionEntity transactionEntity);

}
