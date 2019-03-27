package com.hwua.jsp.serviceImpl;

import com.hwua.jsp.dao.GoodDao;
import com.hwua.jsp.daoImpl.GoodDaoImpl;
import com.hwua.jsp.entity.Good;
import com.hwua.jsp.service.GoodService;

import java.util.List;
import java.util.Map;

public class GoodServiceImpl implements GoodService {

    private GoodDao dao = new GoodDaoImpl();

    @Override
    public Map<String, Object> queryGoodById(int id) {
        return dao.queryGoodById(id);
    }

    @Override
    public List<Good> queryGoodPage(String keyword,int page, int pageSize) {
        int start=(page-1)*pageSize;
        return dao.queryGoodPage(keyword,start,pageSize);
    }

    @Override
    public int queryGoodCount(String keyword) {
        return dao.queryGoodCount(keyword);
    }
}
