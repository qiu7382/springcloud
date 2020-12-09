package com.qzh.springcloud.alibaba.service;

import com.qzh.springcloud.alibaba.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 22:59
 * @Description: com.qzh.springcloud.alibaba.service
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
