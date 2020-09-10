package com.chenming.tmall.user.service.impl;

import com.chenming.tmall.user.entity.UserLogLogin;
import com.chenming.tmall.user.mapper.LogLoginMapper;
import com.chenming.tmall.user.service.ILogLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户错误登录日志 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Service
public class LogLoginServiceImpl extends ServiceImpl<LogLoginMapper, UserLogLogin> implements ILogLoginService {

}
