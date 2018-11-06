package com.blogspot.danserlesgens.dao;

import com.blogspot.danserlesgens.value.AccountValue;
import netscape.javascript.JSObject;

import java.util.List;

public interface IAccountDAO {
    public void create(AccountValue account)throws Exception;
    public void delete(AccountValue account) throws Exception;
    public void update(AccountValue account) throws Exception;
    public List<AccountValue> findAll()throws Exception;
    public AccountValue findByUser(String user) throws Exception;
    public List<AccountValue> findByPage(int pageNumber,int pageSize,String order) throws Exception;
    public List<AccountValue> findByPage(int pageNumber,int pageSize) throws Exception;

    public int listNumber() throws Exception;
}
