package com.chenming.tmall.user.service;

import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.user.UserVo;

/**
 * description: UserService <br>
 * author: chenming <br>
 * date: 2020/9/12 15:00 <br>
 * version: 1.0 <br>
 */
public interface UserService {

    CommonResult<UserVo> getUserById(Long id);
}
