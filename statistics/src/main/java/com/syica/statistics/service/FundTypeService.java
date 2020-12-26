package com.syica.statistics.service;

import com.syica.statistics.bean.FundType;
import com.syica.statistics.dao.FundTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundTypeService {

    @Autowired
    private FundTypeDao fundTypeDao;

    public List<FundType> getAllByUserId(int userId) {
        return this.fundTypeDao.getAllByUserId(userId);
    }

    public int addFundType(FundType fundType) {
        return this.fundTypeDao.addFundType(fundType);
    }
}
