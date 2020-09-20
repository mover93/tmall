package com.chenming.tmall.system.controller;

import com.alibaba.fastjson.JSON;
import com.chenming.tmall.common.dto.system.SysUserLoginDto;
import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.system.SysUserLoginVo;
import com.chenming.tmall.system.service.SysUserLoginService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: SysUserLoginController <br>
 * author: chenming <br>
 * date: 2020/9/20 11:57 <br>
 * version: 1.0 <br>
 */
@Slf4j
@RestController
@RequestMapping(value = "/sys/user")
public class SysUserLoginController {

    @Autowired
    private SysUserLoginService sysUserLoginService;

    @PostMapping(value = "/login")
    public CommonResult<SysUserLoginVo> login(@RequestBody SysUserLoginDto sysUserLoginDto) {
        log.info("SysUserLoginController.login input={}", JSON.toJSONString(sysUserLoginDto));
        if (StringUtils.isEmpty(sysUserLoginDto.getClientId())) {
            return CommonResult.error("clientId is null");
        }
        if (StringUtils.isEmpty(sysUserLoginDto.getIp())) {
            return CommonResult.error("ip is null");
        }
        if (StringUtils.isEmpty(sysUserLoginDto.getMobile())) {
            return CommonResult.error("mobile is null");
        }
        if (StringUtils.isEmpty(sysUserLoginDto.getPassword())) {
            return CommonResult.error("password is null");
        }

        return sysUserLoginService.login(sysUserLoginDto);
    }
}
