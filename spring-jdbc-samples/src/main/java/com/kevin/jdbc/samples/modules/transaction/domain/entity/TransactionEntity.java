package com.kevin.jdbc.samples.modules.transaction.domain.entity;

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
