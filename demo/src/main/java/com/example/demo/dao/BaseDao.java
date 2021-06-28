package com.example.demo.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseDao<T> {

    List<T> getAll();
}
