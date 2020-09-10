package com.chenming.tmall.user.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenming.tmall.user.entity.Region;
import com.chenming.tmall.user.mapper.RegionMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 行政区域表 服务实现类
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Service
public class RegionManager extends ServiceImpl<RegionMapper, Region> {

}
