package com.kevin.jdbc.samples.modules.transaction.service;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.TransactionEntity;

/**
 * @author wangyong
 */
public interface PropagationRequiredBSerivce {

  void payB(TransactionEntity transaction);
}
