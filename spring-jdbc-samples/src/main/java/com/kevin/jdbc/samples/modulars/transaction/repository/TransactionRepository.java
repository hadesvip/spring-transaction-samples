package com.kevin.jdbc.samples.modulars.transaction.repository;

import com.kevin.jdbc.samples.modulars.transaction.domain.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wangyong
 */
@Repository
public interface TransactionRepository {

  void save(TransactionEntity transaction);

}
