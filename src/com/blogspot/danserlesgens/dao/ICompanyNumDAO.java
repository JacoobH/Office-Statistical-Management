package com.blogspot.danserlesgens.dao;

import com.blogspot.danserlesgens.value.CompanyNumValue;

import java.util.List;

public interface ICompanyNumDAO {
    public void create(CompanyNumValue companyNum)throws Exception;
    public void delete(CompanyNumValue companyNum) throws Exception;
    public void update(CompanyNumValue companyNum) throws Exception;
//    public List<CompanyNumValue> findAll()throws Exception;
    public List<CompanyNumValue> findByName(String name) throws Exception;
}
