package com.hwua.jsp.service;

import com.hwua.jsp.entity.address;

import java.util.List;
import java.util.Map;

public interface AreaService {

    public List<Map<String,Object>> queryAreaByPid(int pid);

    public List<Map<String,Object>> queryAddress();

    public int addAddress(address address);

}
