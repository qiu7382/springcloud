package com.qzh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/4 - 21:09
 * @Description: com.qzh.springcloud.alibaba.controller
 */
@RestController
@Slf4j
public class FlowLimitController {

    //流控Warm Up预热
    //阈值/3默认值开始,设点时间内恢复
    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "-----testB";
    }

    //降级策略RT当QPS>5&&响应时长超过阈值断路器打开
    //异常比例,QPS>5&&异常比例达到百分比断路器打开
    @GetMapping("/testD")
    public String testD(){
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        int a = 10/0;

        log.info("testD 测试异常比例"); return "------testD";
    }

    //异常数,分钟为单位大于异常数降级
    @GetMapping("/testE")
    public String testE(){
        int a = 10/0;

        log.info("test 测试异常数"); return "------testE";
    }

    //热点key限流降级
    //设定参数的QPS进行降级,热点key的下标,QPS的阈值,页面恢复时长
    //参数例外项 sentinel控制台某个热点key的特定值下设定限流规则
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                            @RequestParam(value = "p2", required = false) String p2){
        log.info("----testHotKey "+ p1 +", " + p2);
        return "--------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey-------服务降级/(ㄒoㄒ)/~~";
    }

}
