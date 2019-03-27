package com.hwua.jsp.dao;

import com.hwua.jsp.entity.Good;

import java.util.List;
import java.util.Map;

public interface GoodDao {

    public List<Good> queryGoodPage(String keyword, int start, int pageSize);

    public int queryGoodCount(String keyword);

    public Map<String,Object> queryGoodById(int id);
}
