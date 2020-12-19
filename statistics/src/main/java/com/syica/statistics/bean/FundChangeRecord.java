package com.syica.statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 资金变更记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundChangeRecord {

    // primary key
    private int id;

    // 本次记录涉及金额
    private double changeMoney;

    // 记录日期
    private Date recordDate;

    // 变更前总金额
    private double moneyBeforeChange;

    // 变更后总金额
    private double moneyAfterChange;

    // 此记录名称
    private String name;

    // 说明
    private String description;

    // 关联收支类型id
    private int inOutTypeId;

    // 关联收支来源去向id
    private int inOutSourcesId;

    // 关联的总资金id
    private int totalFundsId;

    // 关联用户id
    private int userId;

    // 收支类型
    private InOutType inOutType;

    // 关联收支来源去向
    private InOutSources inOutSources;

    // 关联的总资金
    private TotalFunds totalFunds;
}
