package com.syica.statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 总资金
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalFunds {

    // primary key
    private int id;

    // 总资金
    private double totalFunds;

    // 名称
    private String name;

    // 修改日期 yyyy-MM-dd HH:mm:ss
    private Date updateDate;

    // 说明
    private String description;

    // 关联用户id
    private int userId;

    // 关联资金类型id
    private int fundTypeId;

    // 关联资金类型
    private FundType fundType;
}
