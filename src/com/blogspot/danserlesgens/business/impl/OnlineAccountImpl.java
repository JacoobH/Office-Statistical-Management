package com.blogspot.danserlesgens.business.impl;

import com.blogspot.danserlesgens.business.IOnlineAccount;
import com.blogspot.danserlesgens.value.OnlineAccountValue;

import java.util.List;

public class OnlineAccountImpl implements IOnlineAccount {

    @Override
    public String getListJson(List<OnlineAccountValue> pageList) throws Exception {
        String accountsJson = "";
        for (OnlineAccountValue onlineAccountValue : pageList) {
            accountsJson += "{\n" +
                    "            \"user\": \""+onlineAccountValue.getUser()+"\",\n" +
                    "            \"ip\": \""+onlineAccountValue.getIp()+"\",\n" +
                    "            \"loginTime\": \""+onlineAccountValue.getLoginTime()+"\"  \n" +
                    "        },";
        }
        accountsJson = accountsJson.substring(0,accountsJson.length()-1);
        return accountsJson;
    }
}
