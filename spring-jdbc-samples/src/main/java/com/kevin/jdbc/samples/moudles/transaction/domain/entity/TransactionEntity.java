package com.kevin.jdbc.samples.moudles.transaction.domain.entity;

import org.h2.mvstore.tx.Transaction;

/**
 * @author wangyong
 */
public class TransactionEntity {

  private String transactionId;

  private String name;

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
