package com.kevin.jdbc.samples.modules.transaction.repository;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wangyong
 */
@Repository
public interface TransactionRepository {

  void save(TransactionEntity transaction);

}
