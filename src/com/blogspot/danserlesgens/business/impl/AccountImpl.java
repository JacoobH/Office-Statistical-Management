package com.blogspot.danserlesgens.business.impl;

import com.blogspot.danserlesgens.business.IAccount;
import com.blogspot.danserlesgens.dao.IAccountDAO;
import com.blogspot.danserlesgens.value.AccountValue;

import java.util.List;

import static com.blogspot.danserlesgens.factory.DaoFactory.createAccountDao;

public class AccountImpl implements IAccount {
    @Override
    public boolean add(String user, String ps, String power) throws Exception {
        boolean flag = isExist(user);
        if (!flag){
            IAccountDAO ado = createAccountDao();
            AccountValue av = new AccountValue();
            av.setUser(user);
            av.setPassword(ps);
            av.setPower(power);
            ado = createAccountDao();
            ado.create(av);
        }
        return  flag;
    }

    @Override
    public boolean delete(String user) throws Exception {
        boolean flag = isExist(user);
        if (flag){
            IAccountDAO ado = createAccountDao();
            ado.delete(ado.findByUser(user));
        }
        return  flag;
    }

    @Override
    public boolean modify(String user, String ps,String power) throws Exception {
        boolean flag = isExist(user);
        if (flag){
            IAccountDAO ado = createAccountDao();
            AccountValue av = ado.findByUser(user);
            av.setPassword(ps);
            av.setPower(power);
            ado.update(av);
        }
        return flag;

    }

    @Override
    public List<AccountValue> getList() throws Exception {
        IAccountDAO ado = createAccountDao();
        return ado.findAll();
    }

    @Override
    public List<AccountValue> getPageList(int pageNumber, int pageSize, String order) throws Exception {
        IAccountDAO ado = createAccountDao();
        if (order == null ||order.equals("")){
            return ado.findByPage(pageNumber,pageSize);
        }
        else {
            return ado.findByPage(pageNumber,pageSize,order);
        }

    }

    @Override
    public AccountValue getAccount(String user) throws Exception {
        IAccountDAO ado = createAccountDao();
        return ado.findByUser(user);
    }

    @Override
    public boolean isExist(String user) throws Exception {
        boolean flag = false;
        IAccountDAO ado = createAccountDao();
        if (ado.findByUser(user).getUser() != null){
            flag = true;
        }
        return  flag;
    }

    @Override
    public boolean check(String user, String ps) throws Exception {
        boolean flag = false;
        if(user !=null && ps != null && !user.equals("") && !ps.equals("")){
            IAccountDAO ado = createAccountDao();
            AccountValue av = ado.findByUser(user);
            if(av.getPassword() != null){
                if(av.getPassword().equals(ps)){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public int getPageListNumber() throws Exception {
        IAccountDAO ado = createAccountDao();
        return ado.listNumber();
    }

    @Override
    public String getListJson(List<AccountValue> pageList) throws Exception {

        IAccountDAO ado = createAccountDao();
        String accountsJson = "    {  \n" +
                "        \"total\": "+ado.listNumber()+",   \n" +
                "        \"rows\": [  \n";
        for (AccountValue accountValue : pageList) {
            accountsJson += "{\n" +
                    "            \"user\": \""+accountValue.getUser()+"\",\n" +
                    "            \"password\": \""+accountValue.getPassword()+"\",\n" +
                    "            \"power\": \""+accountValue.getPower()+"\"  \n" +
                    "        },";
        }
        accountsJson = accountsJson.substring(0,accountsJson.length()-1);
        accountsJson+=
                "        ]  \n" +
                "    }  ";
        return accountsJson;
    }

}
