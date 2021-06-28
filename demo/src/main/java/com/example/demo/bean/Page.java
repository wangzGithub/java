package com.example.demo.bean;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    int count;

    List<T> list;
}
