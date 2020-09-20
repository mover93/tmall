package com.chenming.tmall.common.result;

/**
 * description: CustomException <br>
 * author: chenming <br>
 * date: 2020/9/20 18:27 <br>
 * version: 1.0 <br>
 */
public class CustomException extends RuntimeException {

    public CustomException(String desc) {
        super(desc);
    }
}
