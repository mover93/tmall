package com.chenming.tmall.goods;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenming.tmall.goods.entity.User;
import com.chenming.tmall.goods.manager.UserManager;
import com.chenming.tmall.goods.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: GoodsApplicationTests <br>
 * author: chenming <br>
 * date: 2020/9/8 23:23 <br>
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserManager userManager;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelectUser() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testQueryUserById() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id", "1");
        User user = userManager.getOne(qw);
        System.out.println(user);
    }
}
