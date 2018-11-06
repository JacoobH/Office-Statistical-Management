package com.blogspot.danserlesgens.action;

import com.blogspot.danserlesgens.business.ICompany;
import com.blogspot.danserlesgens.business.ICompanyNum;
import com.blogspot.danserlesgens.factory.BusinessFactory;
import com.blogspot.danserlesgens.value.CompanyNumValue;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet(name = "CompanyDBAction",value = "/action/companyDB.do")
public class CompanyDBAction extends HttpServlet {
    private ICompany company;
//    private ICompanyNum companyNum;
    public void init(ServletConfig config){
        company = BusinessFactory.createCompany();
//        companyNum = BusinessFactory.createCompanyNum();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //身份证号合法性
        Pattern pattern = Pattern.compile("^[1-9]\\d{5}(18|19|2([0-9]))\\d{2}(0[0-9]|10|11|12)([0-2][1-9]|30|31)\\d{3}[0-9Xx]$");

        String act = request.getParameter("act");
        String name = request.getParameter("name");
        String man = request.getParameter("man");
        BigDecimal manCardId = null;
        if (request.getParameter("manCardId") != null){
            if (!request.getParameter("manCardId").equals("") &&
                    pattern.matcher(request.getParameter("manCardId")).matches()){
                manCardId = new BigDecimal(request.getParameter("manCardId"));
            }else {
                act = "";
            }
        }
        try {
            switch (act){
                case "add":{
                    addCompany(name,man,manCardId);
                    response.sendRedirect("/pages/property/company_list.jsp");
                    break;
                }
                case "delete":deleteCompany(name);break;
                case "modify":{
                    modifyCompany(name,man,manCardId);
                    response.sendRedirect("/pages/property/company_list.jsp");
                    break;
                }
                case "info":getCompanyInfo(name, response);break;
                case "statistics":getStatistics(response);break;
                default:response.sendRedirect("/pages/property/company_list.jsp");
            }
        } catch (Exception e) {
            System.err.println("CompanyDBAction错误，"+e.getMessage());
            e.printStackTrace();
        }
    }
    private void addCompany(String name,String man,BigDecimal manCardId) throws Exception {
        company.add(name,man,manCardId);
    }
    private void deleteCompany(String names) throws Exception {
        String nameArray[] = names.split(",");
        for (String name : nameArray) {
            boolean flag = company.delete(name);
        }
    }
    private void modifyCompany(String name,String man,BigDecimal manCardId) throws Exception {
        company.modify(name,man,manCardId);
    }
    private void getCompanyInfo(String name,HttpServletResponse response) throws Exception {
        response.setContentType("application/text");
        PrintWriter out = response.getWriter();
        double payment = company.getTotalPay(name);
//        List<CompanyNumValue> companyNumList = companyNum.getList(name);

        out.write(Double.toString(payment));
    }
    private void getStatistics(HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        try(PrintWriter out = response.getWriter();){
            Map<String,Integer> possession = company.getPossession();
            String possessionJson = company.getPossessionJson(possession);
            out.print(possessionJson);
        }
    }
}
