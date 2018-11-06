package com.blogspot.danserlesgens.util.filter;

import com.blogspot.danserlesgens.business.IAccount;
import com.blogspot.danserlesgens.factory.BusinessFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter03_Login",value = "/action/login.do")
public class Filter03_Login implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        boolean flag = false;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        IAccount account = BusinessFactory.createAccount();
        String user = request.getParameter("user");
        String ps = request.getParameter("ps");
        try {
            flag = account.check(user,ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){
            chain.doFilter(req,resp);
        }
        else {
            response.sendRedirect("/index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
