package com.hwua.jsp.dao;

import com.hwua.jsp.entity.address;

import java.util.List;
import java.util.Map;

public interface AreaDao {

    //pid = parentId
    public List<Map<String,Object>> queryAreaByPid(int pid);

    public List<Map<String,Object>> queryAddress();

    public int addArea(address address);

}
