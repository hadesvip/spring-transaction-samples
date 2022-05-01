package com.kevin.mybatis.samples.modules.trade.service;

import com.kevin.mybatis.samples.modules.trade.domain.entity.TradeEntity;
import com.kevin.mybatis.samples.modules.trade.repository.TradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author kevin
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Resource
    private TradeRepository tradeRepository;


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void saveTrade(TradeEntity tradeEntity) {
        tradeRepository.save(tradeEntity);
        if (Objects.equals(tradeEntity.getState(), "NORMAL")) {
            throw new RuntimeException("rollback");
        }

    }

    @Override
    public List<TradeEntity> queryByUserId(Long userId) {
        return tradeRepository.queryByUserId(userId);
    }
}
