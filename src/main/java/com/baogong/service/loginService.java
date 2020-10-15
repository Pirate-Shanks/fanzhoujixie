package com.baogong.service;

import com.baogong.pojo.User;

import java.util.List;

public interface loginService {

    public User login(User user1);

    public  List<String> queryUserSubmitDateByUserId(String user_id, String date1,String date2);
}
