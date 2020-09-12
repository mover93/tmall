package com.chenming.tmall.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenming.tmall.system.entity.Sys;
import com.chenming.tmall.system.manager.SysManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: SystemServiceApplicationTests <br>
 * author: chenming <br>
 * date: 2020/9/12 9:53 <br>
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemServiceApplicationTests {

    @Autowired
    private SysManager sysManager;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testQuerySysById() {
        QueryWrapper<Sys> qw = new QueryWrapper<>();
        qw.eq("id", "1");
        Sys sys = sysManager.getOne(qw);
        System.out.println(sys);
    }
}
