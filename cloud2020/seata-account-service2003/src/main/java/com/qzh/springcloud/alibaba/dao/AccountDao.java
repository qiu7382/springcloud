package com.qzh.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 22:30
 * @Description: com.qzh.springcloud.alibaba.dao
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
