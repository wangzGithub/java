package com.syica.statistics.service;

import com.syica.statistics.bean.InOutType;
import com.syica.statistics.dao.InOutTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InOutTypeService {

    @Autowired
    private InOutTypeDao inOutTypeDao;

    public List<InOutType> getListByUserId(int id) {
        return this.inOutTypeDao.getListByUserId(id);
    }

    public int addInOutType(InOutType inOutType) {
        return this.inOutTypeDao.addInOutType(inOutType);
    }
}
