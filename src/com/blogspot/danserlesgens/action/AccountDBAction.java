package com.blogspot.danserlesgens.action;

import com.blogspot.danserlesgens.business.IAccount;
import com.blogspot.danserlesgens.factory.BusinessFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountDBAction",value = "/action/accountDB.do")
public class AccountDBAction extends HttpServlet {
    private IAccount account;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        String users = request.getParameter("user");
        String ps = request.getParameter("ps");
        String power = request.getParameter("power");
        try {
            switch (act){
                case "add":{
                    addAccount(users,ps,power);
                    response.sendRedirect("/pages/system/account_list.jsp");
                    break;
                }
                case "delete":{
                    deleteAccount(users);
                    break;
                }
                case "modify":{
                    modifyAccount(users,ps,power);
                    response.sendRedirect("/pages/system/account_list.jsp");
                    break;
                }
                default:response.sendRedirect("/pages/system/account_list.jsp");
            }
        } catch (Exception e) {
            System.err.println("AccountDBAction错误，"+e.getMessage());
            e.printStackTrace();
        }
    }
    private void deleteAccount(String users) throws Exception {
        String userArray[] = users.split(",");
        for (String user : userArray) {
            boolean flag = account.delete(user);
        }
    }
    private void addAccount(String user,String ps,String power) throws Exception {
        account.add(user,ps,power);
    }
    private void modifyAccount(String user,String ps,String power) throws Exception {
        account.modify(user,ps,power);
    }
}
