package com.qzh.springcloud.alibaba.service.impl;

import com.qzh.springcloud.alibaba.dao.AccountDao;
import com.qzh.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 15:02
 * @Description: com.qzh.springcloud.alibaba.service.impl
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("----> account-service中扣减用户余额开始");
        accountDao.decrease(userId, money);
        LOGGER.info("----> account-service中扣减用户余额结束");

    }
}
