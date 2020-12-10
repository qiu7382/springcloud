package com.qzh.springcloud.alibaba.controller;

import com.qzh.springcloud.alibaba.service.IdGeneratorSnowflake;
import com.qzh.springcloud.alibaba.service.OrderService;
import com.qzh.springcloud.alibaba.vo.CommonResult;
import com.qzh.springcloud.alibaba.vo.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @RequestMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    @GetMapping("/snowflake")
    public String getIDBySnowflake(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(()->{
                System.out.println(idGeneratorSnowflake.snowflakeId());
                System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}
