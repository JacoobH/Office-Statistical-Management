package com.blogspot.danserlesgens.business.impl;

import com.blogspot.danserlesgens.business.IRoom;
import com.blogspot.danserlesgens.dao.IRoomDAO;
import com.blogspot.danserlesgens.value.RoomValue;

import java.math.BigDecimal;
import java.util.List;
import static com.blogspot.danserlesgens.factory.DaoFactory.createRoomDao;
public class RoomImpl implements IRoom {

    @Override
    public boolean add(BigDecimal id, String comName, Boolean situation, Double money) throws Exception {
        boolean flag = isExist(id);
        if (!flag){
            IRoomDAO rdo = createRoomDao();
            RoomValue rv = new RoomValue();
            rv.setId(id);
            rv.setComName(comName);
            rv.setSituation(situation);
            rv.setMoney(money);
            rdo = createRoomDao();
            rdo.create(rv);
        }
        return  flag;
    }

    @Override
    public boolean delete(BigDecimal id) throws Exception {
        boolean flag = isExist(id);
        if (flag){
            IRoomDAO rdo = createRoomDao();
            rdo.delete(rdo.findById(id));
        }
        return  flag;
    }

    @Override
    public boolean modify(BigDecimal id, String comName, Boolean situation, Double money) throws Exception {
        boolean flag = isExist(id);
        if (flag){
            IRoomDAO rdo = createRoomDao();
            RoomValue rv = rdo.findById(id);
            rv.setComName(comName);
            rv.setSituation(situation);
            rv.setMoney(money);
            rdo.update(rv);
        }
        return flag;
    }

    @Override
    public List<RoomValue> getList() throws Exception {
        IRoomDAO rdo = createRoomDao();
        return rdo.findAll();
    }

    @Override
    public List<RoomValue> getPageList(int pageNumber, int pageSize, String order) throws Exception {
        IRoomDAO rdo = createRoomDao();
        if (order == null || order.equals("")){
            return rdo.findByPage(pageNumber,pageSize);
        }
        else {
            return rdo.findByPage(pageNumber,pageSize,order);
        }
    }

    @Override
    public RoomValue getRoom(BigDecimal id) throws Exception {
        IRoomDAO rdo = createRoomDao();
        return rdo.findById(id);
    }

    @Override
    public boolean isExist(BigDecimal id) throws Exception {
        boolean flag = false;
        IRoomDAO rdo = createRoomDao();
        if (rdo.findById(id).getId() != null){
            flag = true;
        }
        return  flag;
    }

    @Override
    public int getPageListNumber() throws Exception {
        IRoomDAO rdo = createRoomDao();
        return rdo.listNumber();
    }

    @Override
    public String getListJson(List<RoomValue> pageList) throws Exception {
        IRoomDAO rdo = createRoomDao();
        String roomsJson = "    {  \n" +
                "        \"total\": "+rdo.listNumber()+",   \n" +
                "        \"rows\": [  \n";
        for (RoomValue roomValue : pageList) {
            roomsJson += "{\n" +
                    "            \"id\": \""+roomValue.getId()+"\",\n" +
                    "            \"comName\": \""+roomValue.getComName()+"\",\n" +
                    "            \"situation\": \""+roomValue.getSituation()+"\",  \n" +
                    "            \"money\": \""+roomValue.getMoney()+"\"  \n" +
                    "        },";
        }
        roomsJson = roomsJson.substring(0,roomsJson.length()-1);
        roomsJson+=
                "        ]  \n" +
                        "    }  ";
        return roomsJson;
    }
}
