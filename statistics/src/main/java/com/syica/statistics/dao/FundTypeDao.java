package com.syica.statistics.dao;

import com.syica.statistics.bean.FundType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资金类型Dao
 */
@Component
@Mapper
public interface FundTypeDao {

    /**
     * 获取用户关联的所有资金类型
     * @param userId
     * @return
     */
    List<FundType> getAllByUserId(int userId);

    /**
     * 添加资金类型
     * @param fundType
     * @return
     */
    int addFundType(FundType fundType);
}
