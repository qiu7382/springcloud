package com.qzh.springcloud.alibaba.service;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 14:36
 * @Description: com.qzh.springcloud.alibaba.service
 */
public interface StorageService {

    void decrease(Long productId, Integer count);
}
