package com.chenming.tmall.user.service.impl;

import com.chenming.tmall.user.entity.LogModified;
import com.chenming.tmall.user.mapper.LogModifiedMapper;
import com.chenming.tmall.user.service.ILogModifiedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户修改日志 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Service
public class LogModifiedServiceImpl extends ServiceImpl<LogModifiedMapper, LogModified> implements ILogModifiedService {

}
