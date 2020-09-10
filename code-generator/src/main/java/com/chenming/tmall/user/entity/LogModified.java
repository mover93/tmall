package com.chenming.tmall.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户修改日志
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_log_modified")
public class LogModified implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 原手机号
     */
    private String mobileOld;

    /**
     * 新手机
     */
    private String mobileNew;

    /**
     * 备注
     */
    private String remark;


}
