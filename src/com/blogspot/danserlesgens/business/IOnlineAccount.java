package com.blogspot.danserlesgens.business;

import com.blogspot.danserlesgens.value.OnlineAccountValue;

import java.util.List;

public interface IOnlineAccount {
    public String getListJson(List<OnlineAccountValue> pageList) throws Exception;
}
