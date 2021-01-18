package com.syica.statistics.service;

import com.syica.statistics.bean.InOutSources;
import com.syica.statistics.dao.InOutSourcesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InOutSourcesService {

    @Autowired
    private InOutSourcesDao inOutSourcesDao;

    public List<InOutSources> getListByUserId(int userId) {
        return this.inOutSourcesDao.getListByUserId(userId);
    }
}
