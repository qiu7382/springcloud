package com.qzh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qzh.springcloud.entities.CommonResult;
import com.qzh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 16:08
 * @Description: com.qzh.springcloud.alibaba.controller
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    //无配置,仅在sentinel控制台注册
    //@SentinelResource(value = "fallback")
    //配置代码错误的降级服务
    //@SentinelResource(value = "fallback",fallback ="handlerFallback")
    //配置sentinel控制台的限流等降级服务
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")
    //配置代码错误的降级服务及sentinel控制台的限流等降级服务
    @SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        }else if(result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"异常handlerFallback，exception内容： " + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable Long id,BlockException e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"blockHandler-sentinel 限流，BlockException： " + e.getMessage(), payment);
    }
}
