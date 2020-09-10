package com.chenming.tmall.user.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenming.tmall.user.entity.SendSmsLog;
import com.chenming.tmall.user.mapper.SendSmsLogMapper;
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
public class SendSmsLogManager extends ServiceImpl<SendSmsLogMapper, SendSmsLog> {

}
