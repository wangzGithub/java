package com.syica.statistics.dao;

import com.syica.statistics.bean.InOutSources;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收支来源去向DAO
 */
@Component
@Mapper
public interface InOutSourcesDao {

    List<InOutSources> getListByUserId(int userId);

    int getIfHasByName(String name);

    int saveInOutSources(InOutSources inOutSources);

    List<InOutSources> getParentInOutSources(int userId);

    int deleteInOutSources(int id);

    InOutSources getInOutSourcesById(int id);
}
