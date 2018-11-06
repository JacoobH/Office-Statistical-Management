package com.blogspot.danserlesgens.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter01_Encoding", value = "/*")
public class Filter01_Encoding implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        chain.doFilter(req, resp);
        response.setCharacterEncoding("utf-8");
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
