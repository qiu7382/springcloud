package com.qzh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qzh.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
 //   @SentinelResource(value = "paymentInfo", fallback = "handleException",blockHandler = "handleException")
    public String paymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + " 服务不可用");
    }
}
