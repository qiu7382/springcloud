package com.qzh.springcloud.alibaba.controller;

import com.qzh.springcloud.alibaba.service.AccountService;
import com.qzh.springcloud.alibaba.vo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @version 1.0
 * @Auther: qzh
 * @Date: 2020/12/9 - 10:12
 * @Description: com.qzh.springcloud.alibaba.controller
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult create(@RequestParam("userId")Long userId,@RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"账户扣减余额成功");
    }
}
