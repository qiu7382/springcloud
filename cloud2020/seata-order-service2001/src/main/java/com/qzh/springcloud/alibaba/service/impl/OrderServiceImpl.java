package com.qzh.springcloud.alibaba.service.impl;

import com.qzh.springcloud.alibaba.dao.OrderDao;
import com.qzh.springcloud.alibaba.service.AccountService;
import com.qzh.springcloud.alibaba.service.OrderService;
import com.qzh.springcloud.alibaba.service.StorageService;
import com.qzh.springcloud.alibaba.vo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 22:57
 * @Description: com.qzh.springcloud.alibaba.service.impl
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        //1、新建订单
        log.info("-------开始新建订单");
        orderDao.create(order);
        //2、减库存
        log.info("------订单微服务开始调用库存,减库存count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------订单微服务开始调用库存,减库存end");
        //3、扣钱
        log.info("------订单微服务开始调用账户,扣钱money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------订单微服务开始调用账户,扣钱end");

        //4、修改订单状态
        log.info("-------修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("-------修改订单状态结束");

        log.info("-------下订单结束------");
    }
}
