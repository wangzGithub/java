package com.syica.statistics.dao;

import com.syica.statistics.bean.InOutType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收支类型Dao
 */
@Component
@Mapper
public interface InOutTypeDao {

    List<InOutType> getListByUserId(int userId);

    int addInOutType(InOutType inOutType);
}
