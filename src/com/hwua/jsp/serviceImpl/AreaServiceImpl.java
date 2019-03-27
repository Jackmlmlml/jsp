package com.hwua.jsp.serviceImpl;

import com.hwua.jsp.dao.AreaDao;
import com.hwua.jsp.daoImpl.AreaDaoImpl;
import com.hwua.jsp.entity.address;
import com.hwua.jsp.service.AreaService;

import java.util.List;
import java.util.Map;

public class AreaServiceImpl implements AreaService {

    private AreaDao dao= new AreaDaoImpl();

    @Override
    public List<Map<String, Object>> queryAreaByPid(int pid) {
        return dao.queryAreaByPid(pid);
    }

    @Override
    public List<Map<String, Object>> queryAddress() {
        return dao.queryAddress();
    }

    @Override
    public int addAddress(address address) {
        return dao.addArea(address);
    }
}
