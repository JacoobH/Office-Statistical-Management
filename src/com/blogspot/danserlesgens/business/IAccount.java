package com.blogspot.danserlesgens.business;

import com.blogspot.danserlesgens.value.AccountValue;

import java.util.List;

public interface IAccount {
    public boolean add(String user,String ps,String power) throws Exception;
    public boolean delete(String user) throws Exception;
    public boolean modify(String user,String ps,String power) throws Exception;
    public List<AccountValue> getList() throws Exception;
    public List<AccountValue> getPageList(int pageNumber,int pageSize,String order) throws Exception;
    public AccountValue getAccount(String user) throws Exception;
    public boolean isExist(String user) throws Exception;
    public boolean check(String user,String ps) throws Exception;

    public int getPageListNumber() throws Exception;

    public String getListJson(List<AccountValue> pageList) throws Exception;
}
