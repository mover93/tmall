package com.chenming.tmall.user.biz;

import com.chenming.tmall.common.dto.UserPlatformDto;
import com.chenming.tmall.common.result.CommonResult;

/**
 * description: UserPlatformService <br>
 * author: chenming <br>
 * date: 2020/9/13 15:48 <br>
 * version: 1.0 <br>
 */
public interface UserPlatformService {

    CommonResult process(UserPlatformDto userPlatformDto);
}
