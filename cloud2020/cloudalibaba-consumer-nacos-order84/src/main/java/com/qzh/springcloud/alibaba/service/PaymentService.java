package com.qzh.springcloud.alibaba.service;

import com.qzh.springcloud.entities.CommonResult;
import com.qzh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 17:00
 * @Description: com.qzh.springcloud.alibaba.service
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
