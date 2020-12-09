package com.qzh.springcloud.alibaba.controller;

import com.qzh.springcloud.alibaba.service.StorageService;
import com.qzh.springcloud.alibaba.vo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 14:40
 * @Description: com.qzh.springcloud.alibaba.controller
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功");
    }
}
