package com.baogong.service;

import com.baogong.pojo.CheckerUserPick;
import com.baogong.pojo.User;

import java.util.List;

public interface CheckerUserPickService {
    public List<User> queryUserByconditions(CheckerUserPick pick);

    public int queryUserPagesByConditions(CheckerUserPick pick);

   public List<String> queryUserLocalNameByLike(String localName);


}
