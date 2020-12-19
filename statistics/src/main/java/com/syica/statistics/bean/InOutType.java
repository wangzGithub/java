package com.syica.statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收支类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InOutType {

    // primary key
    private int id;

    // code
    private String code;

    // name
    private String name;

    // 关联用户id
    private int userId;
}
