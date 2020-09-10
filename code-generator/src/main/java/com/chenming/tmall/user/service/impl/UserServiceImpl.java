package com.chenming.tmall.user.service.impl;

import com.chenming.tmall.user.entity.User;
import com.chenming.tmall.user.mapper.UserMapper;
import com.chenming.tmall.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
