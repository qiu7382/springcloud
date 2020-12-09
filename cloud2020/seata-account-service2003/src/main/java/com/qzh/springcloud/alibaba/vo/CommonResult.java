package com.qzh.springcloud.alibaba.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/8 - 22:24
 * @Description: com.qzh.springcloud.alibaba.vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}