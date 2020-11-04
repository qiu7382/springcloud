package com.qzh.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo(Integer id) {
        return "--------PaymentFallbackService fallback paymentInfo /(ㄒoㄒ)/~~---------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------PaymentFallbackService fallback paymentInfo_TimeOut /(ㄒoㄒ)/~~---------";
    }
}
