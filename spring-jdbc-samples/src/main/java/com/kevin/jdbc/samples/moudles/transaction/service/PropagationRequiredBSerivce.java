package com.kevin.jdbc.samples.moudles.transaction.service;

import com.kevin.jdbc.samples.moudles.transaction.domain.entity.TransactionEntity;

/**
 * @author wangyong
 */
public interface PropagationRequiredBSerivce {

  void payB(TransactionEntity transaction);
}
