package com.chenming.tmall.zuul.controller;

import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.common.result.ResultCodeEnum;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: ErrorHandlerController <br>
 * author: chenming <br>
 * date: 2020/9/19 23:12 <br>
 * version: 1.0 <br>
 */
@RestController
public class ErrorHandlerController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<String> error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        if(null != throwable && throwable instanceof  ZuulException ){
            ZuulException e = (ZuulException) ctx.getThrowable();
            return CommonResult.error(Integer.toString(e.nStatusCode), e.errorCause);
        }
        return CommonResult.error(ResultCodeEnum.PAGE_NOT_FOUND.getCode(), ResultCodeEnum.PAGE_NOT_FOUND.getDesc());
    }

}
