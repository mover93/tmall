package com.chenming.tmall.user.service.impl;

import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.vo.user.UserVo;
import com.chenming.tmall.user.entity.User;
import com.chenming.tmall.user.manager.UserManager;
import com.chenming.tmall.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: UserServiceImpl <br>
 * author: chenming <br>
 * date: 2020/9/12 15:01 <br>
 * version: 1.0 <br>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public CommonResult<UserVo> getUserById(Long id) {
        User user = userManager.getById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return CommonResult.success(userVo);
    }
}
