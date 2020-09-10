package com.chenming.tmall.user.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenming.tmall.user.entity.User;
import com.chenming.tmall.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Service
public class UserManager extends ServiceImpl<UserMapper, User> {

}
