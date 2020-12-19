package com.syica.statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收支来源去向分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InOutSources {

    // primary key
    private int id;

    // 名称
    private String name;

    // 状态 0启用1停用
    private int status;

    // 上级id
    private int parentId;

    // 收支类型id
    private int inOutTypeId;

    // 收支类型
    private InOutType inOutType;

}
