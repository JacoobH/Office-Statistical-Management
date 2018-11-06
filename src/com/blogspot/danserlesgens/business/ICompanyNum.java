package com.blogspot.danserlesgens.business;

import com.blogspot.danserlesgens.value.CompanyNumValue;

import java.util.List;

public interface ICompanyNum {
    public boolean add(String name,int num) throws Exception;
    public boolean delete(String name) throws Exception;
    public boolean modify(String name,int num) throws Exception;
    public List<CompanyNumValue> getListByName(String name) throws Exception;
    public boolean isExist(String name) throws Exception;
}
