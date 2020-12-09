package com.qzh.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 10:15
 * @Description: com.qzh.springcloud.alibaba.config
 */
@Configuration
@MapperScan({"com.qzh.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
