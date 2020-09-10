package com.chenming.tmall.user.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 讲师信息
 * </p>
 *
 * @author chenming
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Lecturer implements Serializable {

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
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 讲师用户编号
     */
    private Long lecturerUserNo;

    /**
     * 讲师名称
     */
    private String lecturerName;

    /**
     * 讲师手机
     */
    private String lecturerMobile;

    /**
     * 讲师邮箱
     */
    private String lecturerEmail;

    /**
     * 职位
     */
    private String position;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 讲师分成比例
     */
    private BigDecimal lecturerProportion;


}