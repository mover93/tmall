package com.chenming.tmall.common.dto;

import com.chenming.tmall.common.dto.platform.PlatformDto;
import com.chenming.tmall.common.dto.user.UserDto;
import lombok.Data;

import java.io.Serializable;

/**
 * description: UserPlatformDto <br>
 * author: chenming <br>
 * date: 2020/9/13 15:49 <br>
 * version: 1.0 <br>
 */
@Data
public class UserPlatformDto implements Serializable {

    private static final long serialVersionUID = -7951810694904284842L;

    private UserDto userDto;

    private PlatformDto platformDto;
}
