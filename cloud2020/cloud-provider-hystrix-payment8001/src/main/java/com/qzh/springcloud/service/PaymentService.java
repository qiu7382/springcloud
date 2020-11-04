package com.qzh.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo(Integer id){
        return "线程池：" +Thread.currentThread().getName()+ " paymentInfo_OK,id " + id + "\t" + "哈哈O(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池：" +Thread.currentThread().getName()+ " id " + id + "\t" + "哈哈O(∩_∩)O, 耗时:";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：" +Thread.currentThread().getName()+ " 系统繁忙请稍后再试,id " + id + "\t" + "/(ㄒoㄒ)/~~";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuiBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuiBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("-----id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuiBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~  id" + id;
    }
}
