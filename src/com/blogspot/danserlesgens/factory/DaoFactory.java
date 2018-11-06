package com.blogspot.danserlesgens.factory;

import com.blogspot.danserlesgens.dao.IAccountDAO;
import com.blogspot.danserlesgens.dao.ICompanyDAO;
import com.blogspot.danserlesgens.dao.ICompanyNumDAO;
import com.blogspot.danserlesgens.dao.IRoomDAO;
import com.blogspot.danserlesgens.dao.impl.AccountDaoImpl;
import com.blogspot.danserlesgens.dao.impl.CompanyDaoImpl;
import com.blogspot.danserlesgens.dao.impl.CompanyNumDaoImpl;
import com.blogspot.danserlesgens.dao.impl.RoomDaoImpl;

public class DaoFactory {
    public static IAccountDAO createAccountDao(){ return new AccountDaoImpl(); }
    public static IRoomDAO createRoomDao(){return new RoomDaoImpl(); }
    public static ICompanyDAO createCompanyDao(){return new CompanyDaoImpl(); }
    public static ICompanyNumDAO createCompanyNumDao(){return new CompanyNumDaoImpl();}
}
