package com.blogspot.danserlesgens.dao;

import com.blogspot.danserlesgens.value.CompanyValue;

import java.util.List;
import java.util.Map;

public interface ICompanyDAO {
    public void create(CompanyValue company)throws Exception;
    public void delete(CompanyValue company) throws Exception;
    public void update(CompanyValue company) throws Exception;
    public List<CompanyValue> findAll()throws Exception;
    public CompanyValue findByName(String name) throws Exception;
    public List<CompanyValue> findByPage(int pageNumber,int pageSize,String order) throws Exception;
    public List<CompanyValue> findByPage(int pageNumber,int pageSize) throws Exception;

    public int listNumber() throws Exception;
    public double totalPay(CompanyValue company) throws Exception;
    public Map<String,Integer> possession() throws Exception;
}
