package com.example.demo.service;

import com.example.demo.bean.AbstractBean;
import com.example.demo.bean.Page;
import com.example.demo.dao.BaseDao;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractService<BEAN extends AbstractBean, DAO extends BaseDao> {

    protected final DAO dao;

    public Page<BEAN> getAll() {
        System.out.println("Base Service");
        List<BEAN> list = dao.getAll();
        Page<BEAN> page = new Page<BEAN>();
        page.setList(list);
        return page;
    }
}
