package com.kevin.mybatis.samples.modules.trade.service.tests;

import com.kevin.mybatis.samples.configuration.ApplicationConfiguration;
import com.kevin.mybatis.samples.modules.trade.domain.entity.TradeEntity;
import com.kevin.mybatis.samples.modules.trade.service.TradeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
//@SpringJUnitConfig(classes = ApplicationConfiguration.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class TradeServiceTests {


    @Resource
    private ApplicationContext applicationContext;


    @Test
    public void saveTradeTest() {

        TradeService tradeService = applicationContext.getBean(TradeService.class);

        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setTradeNo(UUID.randomUUID().toString());
        tradeEntity.setUserId(1L);
        tradeEntity.setState("NORMAL");
        tradeEntity.setTradeAmount(BigDecimal.valueOf(10.23));
        tradeEntity.setTradeDateTime(new Date());
        try {
            tradeService.saveTrade(tradeEntity);
        } catch (Exception ignored) {

        }


        List<TradeEntity> tradeEntities = tradeService.queryByUserId(1L);

        Logger.getGlobal().info("交易数据:" + tradeEntities);
    }
}
