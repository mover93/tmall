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
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 8212400065048858994L;

    private String code;

    private T t;

    private String msg;

    public CommonResult() {

    }

    public CommonResult(String code, String msg) {
        this(code, msg, null);
    }

    public CommonResult(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
    }

    public static <T> CommonResult<T> success(T t) {
        return new CommonResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc(), t);
    }

    public static <T> CommonResult<T> error() {
        return new CommonResult(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getDesc());
    }

    public static <T> CommonResult<T> error(String msg) {
        return new CommonResult(ResultCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> CommonResult<T> error(String code, String msg) {
        return new CommonResult(code, msg);
    }
}
