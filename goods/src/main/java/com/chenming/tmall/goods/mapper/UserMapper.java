package com.chenming.tmall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenming.tmall.goods.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: UserMapper <br>
 * author: chenming <br>
 * date: 2020/9/9 20:21 <br>
 * version: 1.0 <br>
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
