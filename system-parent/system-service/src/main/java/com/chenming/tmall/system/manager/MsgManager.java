package com.chenming.tmall.system.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenming.tmall.system.entity.Msg;
import com.chenming.tmall.system.mapper.MsgMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站内信息表 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-12
 */
@Service
public class MsgManager extends ServiceImpl<MsgMapper, Msg> {

}
