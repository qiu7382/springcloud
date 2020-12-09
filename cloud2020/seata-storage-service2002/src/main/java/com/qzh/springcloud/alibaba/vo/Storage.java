package com.qzh.springcloud.alibaba.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 14:23
 * @Description: com.qzh.springcloud.alibaba
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;

    private Long productId; //产品id

    private Integer total;  //总数

    private Integer used;   //已用

    private Integer residue;    //剩余
}

