package com.chenming.tmall.common.vo.system;

import lombok.Data;

import java.io.Serializable;

/**
 * description: UserLoginVo <br>
 * author: chenming <br>
 * date: 2020/9/20 11:25 <br>
 * version: 1.0 <br>
 */
@Data
public class SysUserLoginVo implements Serializable {

    private static final long serialVersionUID = 700858325785019364L;

    private String mobile;

    private String token;

    private String userNo;
}
