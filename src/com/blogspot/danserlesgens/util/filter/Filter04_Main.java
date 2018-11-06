package com.blogspot.danserlesgens.util.filter;

import com.blogspot.danserlesgens.business.IAccount;
import com.blogspot.danserlesgens.factory.BusinessFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static com.blogspot.danserlesgens.factory.BusinessFactory.createCompany;
import static com.blogspot.danserlesgens.factory.BusinessFactory.createRoom;

@WebFilter(filterName = "Filter04_Main" , value = "/pages/main.jsp")
public class Filter04_Main implements Filter {
    private ServletContext application;
    private IAccount account;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            //获取用户数量
            application.setAttribute("account_num",account.getPageListNumber());
            //获取单位数量
            application.setAttribute("company_num",createCompany().getPageListNumber());
            //获取办公室数量
            application.setAttribute("room_num",createRoom().getPageListNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        account = BusinessFactory.createAccount();
        application = config.getServletContext();
    }

}
