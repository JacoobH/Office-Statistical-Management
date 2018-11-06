package com.blogspot.danserlesgens.dao;

import com.blogspot.danserlesgens.value.RoomValue;

import java.math.BigDecimal;
import java.util.List;

public interface IRoomDAO {
    public void create(RoomValue room)throws Exception;
    public void delete(RoomValue room) throws Exception;
    public void update(RoomValue room) throws Exception;
    public List<RoomValue> findAll()throws Exception;
    public RoomValue findById(BigDecimal id) throws Exception;
    public List<RoomValue> findByPage(int pageNumber,int pageSize,String order) throws Exception;
    public List<RoomValue> findByPage(int pageNumber,int pageSize) throws Exception;

    public int listNumber() throws Exception;
}
