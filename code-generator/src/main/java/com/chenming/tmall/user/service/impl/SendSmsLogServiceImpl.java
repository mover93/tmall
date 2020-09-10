package com.chenming.tmall.user.service.impl;

import com.chenming.tmall.user.entity.SendSmsLog;
import com.chenming.tmall.user.mapper.SendSmsLogMapper;
import com.chenming.tmall.user.service.ISendSmsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户发送短信日志 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Service
public class SendSmsLogServiceImpl extends ServiceImpl<SendSmsLogMapper, SendSmsLog> implements ISendSmsLogService {

}
