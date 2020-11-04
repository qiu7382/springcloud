package com.qzh.springcloud.service.impl;

import com.qzh.springcloud.dao.PaymentDao;
import com.qzh.springcloud.entities.Payment;
import com.qzh.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);

    }

    public Payment getPaymentById(long id){

        return paymentDao.getPaymentById(id);
    }

}
