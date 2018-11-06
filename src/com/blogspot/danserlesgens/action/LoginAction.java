package com.blogspot.danserlesgens.action;

import com.blogspot.danserlesgens.business.IAccount;
import com.blogspot.danserlesgens.value.AccountValue;
import com.blogspot.danserlesgens.value.OnlineAccountValue;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.blogspot.danserlesgens.factory.BusinessFactory.*;

@WebServlet(name = "LoginAction",value = "/action/login.do")
public class LoginAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        IAccount account = createAccount();
        AccountValue av = null;
        HttpSession session = request.getSession(false);
        ServletContext application = this.getServletContext();
        List<String> userNameList = (List<String>) application.getAttribute("user_name_list");
        if (session.getAttribute("account_user") == null||!userNameList.contains(user)){
            try {
                av = account.getAccount(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(av != null){
                session = request.getSession();
                session.setAttribute("account_user",user);
                session.setAttribute("account_power",av.getPower());
                session.setMaxInactiveInterval(60*60*24);//有效时间1天
            }
            //取得在线人数
            Integer onlineNum = (Integer) application.getAttribute("online_num");
            if (onlineNum == null){
                application.setAttribute("online_num",1);
            }
            else {
                application.setAttribute("online_num",++onlineNum);
            }

            //取得用户在线列表
            List<OnlineAccountValue> userList = (List<OnlineAccountValue>) application.getAttribute("user_list");
            OnlineAccountValue onlineAccount = new OnlineAccountValue();
            onlineAccount.setUser(user);
            onlineAccount.setIp(request.getRemoteAddr());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            onlineAccount.setLoginTime(df.format(new Date()));// new Date()为获取当前系统时间
            if (userList == null){
                userList = new ArrayList<>();
                userList.add(onlineAccount);
                application.setAttribute("user_list",userList);
            }
            else {
                userList.add(onlineAccount);
            }

            //用户名在线列表
            if (userNameList == null){
                userNameList = new ArrayList<>();
                userNameList.add(user);
                application.setAttribute("user_name_list",userNameList);
            }
            else {
                userNameList.add(user);
            }
        }
        response.sendRedirect("../pages/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
