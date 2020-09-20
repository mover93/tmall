package com.chenming.tmall.system.service.impl;

import com.chenming.tmall.common.LoginConst;
import com.chenming.tmall.common.dto.system.SysUserDto;
import com.chenming.tmall.common.dto.system.SysUserLoginDto;
import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.system.SysUserLoginVo;
import com.chenming.tmall.system.config.Audience;
import com.chenming.tmall.system.feign.PlatformClient;
import com.chenming.tmall.system.manager.SysUserManager;
import com.chenming.tmall.system.service.SysUserLoginService;
import com.chenming.tmall.system.util.JwtTokenUtil;
import com.chenming.tmall.system.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: SysUserLoginServiceImpl <br>
 * author: chenming <br>
 * date: 2020/9/20 12:05 <br>
 * version: 1.0 <br>
 */
@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

    @Autowired
    private PlatformClient platformClient;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private Audience audience;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public CommonResult<SysUserLoginVo> login(SysUserLoginDto sysUserLoginDto) {
        CommonResult<Boolean> result = platformClient.existsPlatform(sysUserLoginDto.getClientId());
        if (!result.getT()) {
            return CommonResult.error("该平台不存在");
        }

        SysUserDto sysUserDto = sysUserManager.getSysUserByMobile(sysUserLoginDto.getMobile());
        if (sysUserDto == null) {
            return CommonResult.error("账号或者密码不正确");
        }

        final String token = JwtTokenUtil.createJWT(sysUserDto.getUserNo().toString(),
                sysUserDto.getRealName(),
                "admin",
                audience);
        final String key = LoginConst.USER_PREFIX + sysUserDto.getUserNo().toString();
        redisUtils.put(key, token, 7200000L);

        SysUserLoginVo sysUserLoginVo = new SysUserLoginVo();
        sysUserLoginVo.setMobile(sysUserDto.getMobile());
        sysUserLoginVo.setToken(token);
        sysUserLoginVo.setUserNo(sysUserDto.getUserNo().toString());

        return CommonResult.success(sysUserLoginVo);
    }
}
