package com.chenming.tmall.common.dto.system;

import lombok.Data;

import java.io.Serializable;

/**
 * description: UserLoginDto <br>
 * author: chenming <br>
 * date: 2020/9/20 11:19 <br>
 * version: 1.0 <br>
 */
@Data
public class SysUserLoginDto implements Serializable {

    private static final long serialVersionUID = 5325419180551615264L;

    private String clientId;

    private String ip;

    private String mobile;

    private String password;
}
