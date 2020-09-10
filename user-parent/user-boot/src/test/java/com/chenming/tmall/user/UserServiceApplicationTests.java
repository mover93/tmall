package com.chenming.tmall.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenming.tmall.user.entity.User;
import com.chenming.tmall.user.manager.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: UserServiceApplicationTests <br>
 * author: chenming <br>
 * date: 2020/9/10 22:17 <br>
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

    @Autowired
    private UserManager userManager;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testQueryUserById() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id", "1");
        User user = userManager.getOne(qw);
        System.out.println(user);
    }
}
