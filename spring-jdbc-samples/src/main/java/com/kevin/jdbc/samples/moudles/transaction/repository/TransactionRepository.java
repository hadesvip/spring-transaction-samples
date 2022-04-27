package com.kevin.jdbc.samples.moudles.transaction.repository;

import com.kevin.jdbc.samples.moudles.transaction.domain.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wangyong
 */
@Repository
public interface TransactionRepository {

  void save(TransactionEntity transaction);

}
