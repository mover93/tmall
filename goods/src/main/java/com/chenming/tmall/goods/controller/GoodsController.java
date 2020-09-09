package com.chenming.tmall.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: GoodsController <br>
 * author: chenming <br>
 * date: 2020/9/8 23:38 <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @GetMapping(value = "/{goodsId}")
    public String index(@PathVariable("goodsId") String goodsId) {
        return "hello world " + goodsId;
    }
}
