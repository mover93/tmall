package com.chenming.tmall.user.service;

import com.chenming.tmall.common.dto.user.UserDto;
import com.chenming.tmall.common.vo.user.UserVo;

/**
 * description: UserService <br>
 * author: chenming <br>
 * date: 2020/9/12 15:00 <br>
 * version: 1.0 <br>
 */
public interface UserService {

    /**
     * 根据id返回用户
     * @param id
     * @return
     */
    UserVo getUserById(Long id);

    /**
     * 新增用户
     * @param userDto
     * @return
     */
    boolean addUser(UserDto userDto);
}
