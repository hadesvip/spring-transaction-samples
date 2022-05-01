package com.kevin.mybatis.samples.modules.trade.service;

import com.kevin.mybatis.samples.modules.trade.domain.entity.TradeEntity;

import java.util.List;

/**
 * @author kevin
 */
public interface TradeService {

    void saveTrade(TradeEntity tradeEntity);


    List<TradeEntity> queryByUserId(Long userId);

}
