package com.qzh.springcloud.alibaba.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/2 - 11:32
 * @Description: com.qzh.springcloud.alibaba.config
 */
@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
