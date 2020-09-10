package com.chenming.tmall.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * description: ResponseVO <br>
 * author: chenming <br>
 * date: 2020/9/10 10:01 <br>
 * version: 1.0 <br>
 */
@Data
public class ResponseVO<T> implements Serializable {

    private static final long serialVersionUID = 8212400065048858994L;

    private String code;

    private T t;

    private String msg;
}
