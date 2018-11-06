package com.blogspot.danserlesgens.business;

import com.blogspot.danserlesgens.value.CompanyValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ICompany {
    public boolean add(String name, String man, BigDecimal manCardId) throws Exception;
    public boolean delete(String name) throws Exception;
    public boolean modify(String name, String man, BigDecimal manCardId) throws Exception;
    public List<CompanyValue> getList() throws Exception;
    public List<CompanyValue> getPageList(int pageNumber,int pageSize,String order) throws Exception;
    public CompanyValue getCompany(String name) throws Exception;
    public boolean isExist(String name) throws Exception;
//    public boolean check(String user,String ps) throws Exception;

    public int getPageListNumber() throws Exception;

    public String getListJson(List<CompanyValue> pageList) throws Exception;
    public double getTotalPay(String name) throws Exception;
    public Map<String,Integer> getPossession() throws Exception;
    public String getPossessionJson(Map<String,Integer> possession) throws Exception;
}
