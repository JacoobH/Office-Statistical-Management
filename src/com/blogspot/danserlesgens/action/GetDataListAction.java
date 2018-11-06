package com.blogspot.danserlesgens.action;

import com.blogspot.danserlesgens.business.IAccount;
import com.blogspot.danserlesgens.business.ICompany;
import com.blogspot.danserlesgens.business.IOnlineAccount;
import com.blogspot.danserlesgens.business.IRoom;
import com.blogspot.danserlesgens.factory.BusinessFactory;
import com.blogspot.danserlesgens.value.AccountValue;
import com.blogspot.danserlesgens.value.CompanyValue;
import com.blogspot.danserlesgens.value.OnlineAccountValue;
import com.blogspot.danserlesgens.value.RoomValue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetDataListAction", value = "/action/getDataList.do")
public class GetDataListAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String act = request.getParameter("act");
        try {
            switch (act){
                case "GetAccountList":getAccountList(request,response);break;
                case "GetOnlineAccountList":getOnlineAccountList(request,response);break;
                case "GetRoomList":getRoomList(request,response);break;
                case "GetCompanyList":getCompanyList(request,response);break;
                default:{
                    RequestDispatcher rd = request.getRequestDispatcher(request.getRequestURI());//转发到 请求的URI
                    rd.forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //得到用户列表
    private void getAccountList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter pw = response.getWriter();

        //得到客户端传递的页码和每页记录数，并转换成int类型
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String searchText = request.getParameter("searchText");
        IAccount account = BusinessFactory.createAccount();


        List<AccountValue> accountList = null;
        String accountJson = null;

        try {
            //分页查找商品销售记录，需判断是否有带查询条件
            accountList = account.getPageList(pageNumber, pageSize, searchText);
            //将商品销售记录转换成json字符串
            accountJson = account.getListJson(accountList);


//        String sellRecordJson = sellRecordService.getSellRecordJson(sellRecordList);
            //得到总记录数
//            int total = account.getPageListNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //需要返回的数据有总记录数和行数据
        pw.print(accountJson);
    }
    private void getOnlineAccountList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter pw = response.getWriter();

        //得到客户端传递的页码和每页记录数，并转换成int类型
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
//        String searchText = request.getParameter("searchText");
        ServletContext application = this.getServletContext();
        IOnlineAccount onlineAccount = BusinessFactory.createOnlineAccount();

        List<OnlineAccountValue> onlineAccountList = (List<OnlineAccountValue>) application.getAttribute("user_list");
        String onlineAccountJson = onlineAccount.getListJson(onlineAccountList);
        pw.print("    {  \n" +
                "        \"total\": "+application.getAttribute("online_num")+",   \n" +
                "        \"rows\": [  \n"
                +onlineAccountJson+
                "        ]  \n" +
                "    }  "
        );


    }
    private void getRoomList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //将Company名字的列表储存到ServletContext中
        try {
            ICompany company = BusinessFactory.createCompany();
            this.getServletContext().setAttribute("company_list",company.getList());
        } catch (Exception e) {
            System.err.println("RoomDBAction得到Company名字的列表错误，"+e.getMessage());
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();

        //得到客户端传递的页码和每页记录数，并转换成int类型
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String searchText = request.getParameter("searchText");
        IRoom room = BusinessFactory.createRoom();

        List<RoomValue> roomList = null;
        String roomJson = null;
        try {
            //分页查找商品销售记录，需判断是否有带查询条件
            roomList = room.getPageList(pageNumber, pageSize, searchText);
            //将商品销售记录转换成json字符串
            roomJson = room.getListJson(roomList);
//        String sellRecordJson = sellRecordService.getSellRecordJson(sellRecordList);
            //得到总记录数
//            int total = account.getPageListNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //需要返回的数据有总记录数和行数据
        out.print(roomJson);
    }
    private void getCompanyList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out = response.getWriter();

        //得到客户端传递的页码和每页记录数，并转换成int类型
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String searchText = request.getParameter("searchText");
        ICompany company = BusinessFactory.createCompany();


        List<CompanyValue> companyList = null;
        String companyJson = null;

        try {
            //分页查找商品销售记录，需判断是否有带查询条件
            companyList = company.getPageList(pageNumber, pageSize, searchText);
            //将商品销售记录转换成json字符串
            companyJson = company.getListJson(companyList);


//        String sellRecordJson = sellRecordService.getSellRecordJson(sellRecordList);
            //得到总记录数
//            int total = account.getPageListNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //需要返回的数据有总记录数和行数据
        out.print(companyJson);
    }
}
