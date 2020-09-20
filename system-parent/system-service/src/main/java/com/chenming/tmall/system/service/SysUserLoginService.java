package com.chenming.tmall.system.service;

import com.chenming.tmall.common.dto.system.SysUserLoginDto;
import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.system.SysUserLoginVo;

/**
 * description: SysUserLoginService <br>
 * author: chenming <br>
 * date: 2020/9/20 12:03 <br>
 * version: 1.0 <br>
 */
public interface SysUserLoginService {

    /**
     * 运营管理用户登录
     * @param sysUserLoginDto
     * @return
     */
    CommonResult<SysUserLoginVo> login(SysUserLoginDto sysUserLoginDto);
}
