package com.kevin.jdbc.samples.modulars.transaction.service;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.TransactionEntity;

/**
 * @author kevin
 */
public interface PropagationRequiresNewBService {

  void payB(TransactionEntity transactionEntity);

}
