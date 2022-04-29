package com.kevin.jdbc.samples.modulars.transaction.service;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.TransactionEntity;

/**
 * @author wangyong
 */
public interface PropagationRequiredBSerivce {

  void payB(TransactionEntity transaction);
}
