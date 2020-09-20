package com.chenming.tmall.user.controller;

import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.user.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: PlatformController <br>
 * author: chenming <br>
 * date: 2020/9/20 12:20 <br>
 * version: 1.0 <br>
 */
@RestController
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(value = "/user/platform")
    public CommonResult<Boolean> existsPlatform(@RequestParam String clientId) {
        return CommonResult.success(platformService.existsPlatform(clientId));
    }
}
