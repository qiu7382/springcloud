package com.qzh.springcloud.alibaba.dao;

import com.qzh.springcloud.alibaba.vo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 22:30
 * @Description: com.qzh.springcloud.alibaba.dao
 */
@Mapper
public interface OrderDao {
    // 新建订单
    void create(Order order);

    //修改订单状态0->1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
