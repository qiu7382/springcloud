package com.qzh.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 22:59
 * @Description: com.qzh.springcloud.alibaba.service
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
