package com.baogong.service.Impl;

import com.baogong.dao.UserDao;
import com.baogong.pojo.User;
import com.baogong.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private UserDao userDao;



    @Override
    public User login(User user1) {
        User user= userDao.findById(user1.getUser_id());
        if(user!=null){
        user.setUser_local_name(userDao.findLocalNameById(user.getUser_local()));}
        return user;
    }

    @Override
    public List<String> queryUserSubmitDateByUserId(String user_id, String date1,String date2) {
        List<String> list = userDao.queryUserSubmitDateByUserId(user_id,date1,date2);
        if(list==null) return null;
        List<String> list1 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i).substring(8));
        }
        return list1;
    }
}
