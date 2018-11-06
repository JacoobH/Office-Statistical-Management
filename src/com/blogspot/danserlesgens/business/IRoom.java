package com.blogspot.danserlesgens.business;

import com.blogspot.danserlesgens.value.RoomValue;

import java.math.BigDecimal;
import java.util.List;

public interface IRoom {
    public boolean add(BigDecimal id, String comName, Boolean situation,Double money) throws Exception;
    public boolean delete(BigDecimal id) throws Exception;
    public boolean modify(BigDecimal id, String comName, Boolean situation,Double money) throws Exception;
    public List<RoomValue> getList() throws Exception;
    public List<RoomValue> getPageList(int pageNumber,int pageSize,String order) throws Exception;
    public RoomValue getRoom(BigDecimal id) throws Exception;
    public boolean isExist(BigDecimal id) throws Exception;
//    public boolean check(BigDecimal id, String comName, Boolean situation,Double money) throws Exception;

    public int getPageListNumber() throws Exception;

    public String getListJson(List<RoomValue> pageList) throws Exception;
}
