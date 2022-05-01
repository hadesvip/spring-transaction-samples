package com.kevin.mybatis.samples.modules.trade.domain.entity;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kevin
 */
public class TradeEntity {

    private Long tradeId;

    private String tradeNo;

    private Long userId;

    private String state;

    private BigDecimal tradeAmount;

    private Date tradeDateTime;

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Date getTradeDateTime() {
        return tradeDateTime;
    }

    public void setTradeDateTime(Date tradeDateTime) {
        this.tradeDateTime = tradeDateTime;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
