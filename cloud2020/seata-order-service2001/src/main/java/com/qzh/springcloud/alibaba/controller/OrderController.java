package com.qzh.springcloud.alibaba.controller;

import com.qzh.springcloud.alibaba.service.OrderService;
import com.qzh.springcloud.alibaba.vo.CommonResult;
import com.qzh.springcloud.alibaba.vo.Order;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 10:12
 * @Description: com.qzh.springcloud.alibaba.controller
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
