package com.qzh.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qzh.springcloud.entities.CommonResult;
import com.qzh.springcloud.entities.Payment;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/6 - 19:58
 * @Description: com.qzh.springcloud.alibaba.myhandler
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按照客户自定义的Glogal 全局异常处理 ---- 1", new Payment(2020L,"serial003"));
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按照客户自定义的Glogal 全局异常处理 ---- 2", new Payment(2020L,"serial003"));
    }
}
