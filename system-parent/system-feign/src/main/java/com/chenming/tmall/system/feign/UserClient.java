package com.chenming.tmall.system.feign;

import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.user.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * description: UserClient <br>
 * author: chenming <br>
 * date: 2020/9/12 11:29 <br>
 * version: 1.0 <br>
 */
@FeignClient(value = "user-service9")
public interface UserClient {

    @GetMapping(value = "/user/{id}")
    CommonResult<UserVo> getUserById(@PathVariable(value = "id") Long id);
}
