package com.blogspot.danserlesgens.action;

import com.blogspot.danserlesgens.value.OnlineAccountValue;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LogoutAction",value = "/action/logout.do")
public class LogoutAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session != null){
            String user = (String) session.getAttribute("account_user");
            ServletContext application = this.getServletContext();

            //在线人数-1
            Integer onlineNum = (Integer) application.getAttribute("online_num");
            if(onlineNum !=null){
                application.setAttribute("online_num", --onlineNum);
            }

            //从在线用户列表中移除用户
            List<OnlineAccountValue> userList = (List<OnlineAccountValue>) application.getAttribute("user_list");
            OnlineAccountValue removeAccount = null;
            if (userList != null){
//                userList.remove(user);
                for (OnlineAccountValue onlineAccount : userList){
                    if (onlineAccount.getUser().equals(user)){
                        removeAccount = onlineAccount;
                        break;
                    }
                }
                userList.remove(removeAccount);
            }

            //销毁session对象
            session.invalidate();
        }
        response.sendRedirect("/index.jsp");
    }
}
