package com.qzh.springcloud.alibaba.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/10 - 12:16
 * @Description: com.qzh.springcloud.alibaba.service
 */
@Slf4j
@Component
public class IdGeneratorSnowflake {
    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    public void init(){
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId:{}", workerId);
        } catch (Exception e) {
            log.info("当前机器的workerId获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();
            log.info("当前机器的workerId获取失败", e);

        }
    }

    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized  long snowfalkeId(long workerId, long datacenterId){
        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return  snowflake.nextId();
    }

    public static void main(String[] args) {
        System.out.println(new IdGeneratorSnowflake().snowflakeId());
    }
}
