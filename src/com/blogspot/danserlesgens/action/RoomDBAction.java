package com.blogspot.danserlesgens.action;


import com.blogspot.danserlesgens.business.IRoom;
import com.blogspot.danserlesgens.factory.BusinessFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "RoomDBAction",value = "/action/roomDB.do")
public class RoomDBAction extends HttpServlet {
    private IRoom room;
    private String ids;//方法中转换为BigDecimal
    private String comName;
    private boolean situation;
    private double money;
    @Override
    public void init(ServletConfig config){

        room = BusinessFactory.createRoom();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String act = request.getParameter("act");
        ids = request.getParameter("id");
        if(request.getParameter("comName")!=null && !request.getParameter("comName").equals("")){
            comName = request.getParameter("comName");
        }
        situation = Boolean.parseBoolean(request.getParameter("situation"));
        if(request.getParameter("money")!=null && !request.getParameter("money").equals("")){
            money = Double.parseDouble(request.getParameter("money"));
        }
        try {
            switch (act){
                case "add":{
                    addRoom(ids,comName,situation,money);
                    response.sendRedirect("/pages/property/room_list.jsp");
                    break;
                }
                case "delete":{
                    deleteRoom(ids);
                    break;
                }
                case "modify":{
                    modifyRoom(ids,comName,situation,money);
                    response.sendRedirect("/pages/property/room_list.jsp");
                    break;
                }
                default:response.sendRedirect("/pages/property/room_list.jsp");
            }
        } catch (Exception e) {
            System.err.println("RoomDBAction错误，"+e.getMessage());
            e.printStackTrace();
        }
    }
    private void addRoom(String id,String comName,boolean situation,double money) throws Exception {
        room.add(new BigDecimal(id),comName,situation,money);
//        System.out.println("增加房间");
    }
    private void deleteRoom(String ids) throws Exception {
        String idArray[] = ids.split(",");
        for (String id : idArray) {
            boolean flag = room.delete(new BigDecimal(id));
        }
//        System.out.println("删除房间");
    }
    private void modifyRoom(String id,String comName,boolean situation,double money) throws Exception {
        room.modify(new BigDecimal(id),comName,situation,money);
//        System.out.println("修改房间");
    }
}
