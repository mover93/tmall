package com.chenming.tmall.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 站内信用户记录表
 * </p>
 *
 * @author chenming
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MsgUser implements Serializable {

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
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态(1有效, 0无效)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 短信ID
     */
    private Long msgId;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 短信类型(1系统消息,2其他)
     */
    private Integer msgType;

    /**
     * 短信标题
     */
    private String msgTitle;

    /**
     * 是否阅读(1是;0否)
     */
    private Integer isRead;

    /**
     * 是否置顶(1是;0否)
     */
    private Integer isTop;


}
