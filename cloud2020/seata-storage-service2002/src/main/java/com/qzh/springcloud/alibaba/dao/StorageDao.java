package com.qzh.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 14:28
 * @Description: com.qzh.springcloud.alibaba.dao
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
