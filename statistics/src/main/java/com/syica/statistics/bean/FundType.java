package com.syica.statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 资金类型，现金、信用卡、花呗等
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundType {

    // primary key
    private int id;

    // code
    private String code;

    // name
    private String name;

    // 状态 0启用1停用
    private int status;

    // 关联用户id
    private int userId;
}
