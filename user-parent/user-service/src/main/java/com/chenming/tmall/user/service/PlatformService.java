package com.chenming.tmall.user.service;

import com.chenming.tmall.common.dto.platform.PlatformDto;

/**
 * description: PlatformService <br>
 * author: chenming <br>
 * date: 2020/9/13 15:37 <br>
 * version: 1.0 <br>
 */
public interface PlatformService {

    /**
     * 新增平台
     * @param platformDto
     * @return
     */
    boolean addPlatform(PlatformDto platformDto);

    /**
     * 根据clientId判断平台是否存在
     * @param clientId
     * @return
     */
    boolean existsPlatform(String clientId);
}
