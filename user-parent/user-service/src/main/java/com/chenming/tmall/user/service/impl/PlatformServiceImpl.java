package com.chenming.tmall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenming.tmall.common.dto.platform.PlatformDto;
import com.chenming.tmall.user.entity.Platform;
import com.chenming.tmall.user.manager.PlatformManager;
import com.chenming.tmall.user.service.PlatformService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * description: PlatformServiceImpl <br>
 * author: chenming <br>
 * date: 2020/9/13 15:40 <br>
 * version: 1.0 <br>
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformManager platformManager;

    @Override
    public boolean addPlatform(PlatformDto platformDto) {
        Platform platform = new Platform();
        BeanUtils.copyProperties(platformDto, platform);
        platform.setGmtCreate(LocalDateTime.now());
        platform.setStatusId(1);
        return platformManager.save(platform);
    }

    @Override
    public boolean existsPlatform(String clientId) {
        QueryWrapper<Platform> qw = new QueryWrapper<>();
        qw.eq("client_id", clientId);
        qw.eq("status_id", "1");
        int count = platformManager.count(qw);
        return count > 0 ? true : false;
    }
}
