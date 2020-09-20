package com.chenming.tmall.system.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenming.tmall.common.dto.system.SysUserDto;
import com.chenming.tmall.system.entity.SysUser;
import com.chenming.tmall.system.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户信息 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-12
 */
@Service
public class SysUserManager extends ServiceImpl<SysUserMapper, SysUser> {

    @Resource
    private SysUserMapper sysUserMapper;

    public SysUserDto getSysUserByMobile(String mobile) {
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("mobile", mobile);
        qw.eq("status_id", 1);
        SysUser sysUser = sysUserMapper.selectOne(qw);
        if (sysUser != null) {
            SysUserDto sysUserDto = new SysUserDto();
            BeanUtils.copyProperties(sysUser, sysUserDto);
            return sysUserDto;
        }
        return null;
    }
}
