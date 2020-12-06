package com.qzh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qzh.springcloud.entities.CommonResult;
import com.qzh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/6 - 17:41
 * @Description: com.qzh.springcloud.alibaba.controller
 */
@RestController
@Slf4j
public class RateLimitController {

    //流控,通过资源名byResource设定阈值流控
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源吗限流", new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + " 服务不可用");
    }

    //流控,通过url地址/retaLimit/byUrl设定阈值流控
    @GetMapping("/retaLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试", new Payment(2020L,"serial001"));
    }

}
