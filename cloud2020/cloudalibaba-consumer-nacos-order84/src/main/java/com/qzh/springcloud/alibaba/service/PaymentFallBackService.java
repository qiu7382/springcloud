package com.qzh.springcloud.alibaba.service;

import com.qzh.springcloud.entities.CommonResult;
import com.qzh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 17:02
 * @Description: com.qzh.springcloud.alibaba.service
 */
@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回，---PaymentFallbackService",new Payment(id,"ErrorSerial"));
    }
}
