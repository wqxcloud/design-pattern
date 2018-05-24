package com.xiaoxin.dubbo.service.impl;

import com.xiaoxin.dubbo.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 暴露方法：使用dubbo service注解
 *
 * @Auther zhangyongxin
 * @date 2018/5/24 上午10:12
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {
    @Override
    public void addStockInfo() {
        log.info("invoked method StockServiceImpl.addStockInfo");
    }
}
