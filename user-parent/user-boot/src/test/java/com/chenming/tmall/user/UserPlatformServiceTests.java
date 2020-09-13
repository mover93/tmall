package com.chenming.tmall.user;

import com.chenming.tmall.common.dto.UserPlatformDto;
import com.chenming.tmall.common.dto.platform.PlatformDto;
import com.chenming.tmall.common.dto.user.UserDto;
import com.chenming.tmall.user.biz.UserPlatformService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: UserPlatformServiceTests <br>
 * author: chenming <br>
 * date: 2020/9/13 15:57 <br>
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPlatformServiceTests {

    @Autowired
    private UserPlatformService userPlatformService;

    @Test
    public void testProcess() {
        UserPlatformDto dto = new UserPlatformDto();
        UserDto userDto = new UserDto();
        userDto.setMobile("13588464127");
        userDto.setMobileSalt("1233455");
        userDto.setMobilePsw("222");
        dto.setUserDto(userDto);

        PlatformDto platformDto = new PlatformDto();
        platformDto.setClientName("ceshi");
        dto.setPlatformDto(platformDto);

        userPlatformService.process(dto);
    }
}
