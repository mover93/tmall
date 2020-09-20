package com.chenming.tmall.system.feign;

import com.chenming.tmall.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: PlatformClient <br>
 * author: chenming <br>
 * date: 2020/9/20 12:14 <br>
 * version: 1.0 <br>
 */
@FeignClient(value = "user-service")
public interface PlatformClient {

    @GetMapping(value = "/user/platform")
    CommonResult<Boolean> existsPlatform(@RequestParam(value = "clientId") String clientId);
}
