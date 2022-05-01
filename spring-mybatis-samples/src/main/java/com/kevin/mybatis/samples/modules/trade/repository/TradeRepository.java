package com.kevin.mybatis.samples.modules.trade.repository;

import com.kevin.mybatis.samples.modules.trade.domain.entity.TradeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public interface TradeRepository {

     int save(TradeEntity tradeEntity);


     List<TradeEntity> queryByUserId(@Param("userId")Long userId);




}
