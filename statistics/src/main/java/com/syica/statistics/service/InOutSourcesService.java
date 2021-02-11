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

    public int getIfHasByName(String name) {
        return this.inOutSourcesDao.getIfHasByName(name);
    }

    public int saveInOutSources(InOutSources inOutSources) {
        return this.inOutSourcesDao.saveInOutSources(inOutSources);
    }

    public List<InOutSources> getParentInOutSources(int userId) {
        return this.inOutSourcesDao.getParentInOutSources(userId);
    }

    public int deleteInOutSources(int id) {
        return this.inOutSourcesDao.deleteInOutSources(id);
    }
}
