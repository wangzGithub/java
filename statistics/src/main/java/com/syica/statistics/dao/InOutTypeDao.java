package com.syica.statistics.dao;

import com.syica.statistics.bean.InOutType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收支分类Dao
 */
@Component
@Mapper
public interface InOutTypeDao {

    List<InOutType> getListByUserId(int userId);

    int addInOutType(InOutType inOutType);

    int deleteInOutType(int id);

    InOutType getInOutTypeById(int id);
}
