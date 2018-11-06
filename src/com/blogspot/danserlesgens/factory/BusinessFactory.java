package com.blogspot.danserlesgens.factory;

import com.blogspot.danserlesgens.business.*;
import com.blogspot.danserlesgens.business.impl.*;

public class BusinessFactory {
    public static IAccount createAccount(){ return new AccountImpl(); }
    public static IOnlineAccount createOnlineAccount(){ return new OnlineAccountImpl(); }
    public static IRoom createRoom(){ return new RoomImpl(); }
    public static ICompany createCompany(){ return new CompanyImpl(); }
//    public static ICompanyNum createCompanyNum(){return new CompanyNumImpl(); }
}
