package com.chenming.tmall.goods.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description: User <br>
 * author: chenming <br>
 * date: 2020/9/9 20:16 <br>
 * version: 1.0 <br>
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -963232655161576774L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer statusId;

    private Long userNo;

    private String mobile;

    private String mobileSalt;

    private String mobilePsw;

    private String userSource;
}
