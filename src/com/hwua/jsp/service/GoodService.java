package com.hwua.jsp.service;

import com.hwua.jsp.entity.Good;

import java.util.List;
import java.util.Map;

public interface GoodService {

    public List<Good> queryGoodPage(String keyword, int page, int pageSize);

    public int queryGoodCount(String keyword);

    public Map<String,Object> queryGoodById(int id);

}
