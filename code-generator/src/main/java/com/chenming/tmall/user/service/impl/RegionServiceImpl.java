package com.chenming.tmall.user.service.impl;

import com.chenming.tmall.user.entity.Region;
import com.chenming.tmall.user.mapper.RegionMapper;
import com.chenming.tmall.user.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

}
