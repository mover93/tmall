package com.chenming.tmall.goods.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenming.tmall.goods.entity.User;
import com.chenming.tmall.goods.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * description: UserManager <br>
 * author: chenming <br>
 * date: 2020/9/9 22:56 <br>
 * version: 1.0 <br>
 */
@Component
public class UserManager extends ServiceImpl<UserMapper, User> {
}
