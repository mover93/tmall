package com.chenming.tmall.user.controller;

import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.user.UserVo;
import com.chenming.tmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: UserController <br>
 * author: chenming <br>
 * date: 2020/9/12 14:57 <br>
 * version: 1.0 <br>
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public CommonResult<UserVo> getUserById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }
}
