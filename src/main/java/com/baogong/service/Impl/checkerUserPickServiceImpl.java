package com.baogong.service.Impl;

import com.baogong.dao.CheckerUserPickDao;
import com.baogong.dao.UserDao;
import com.baogong.pojo.CheckerUserPick;
import com.baogong.pojo.User;
import com.baogong.service.CheckerUserPickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class checkerUserPickServiceImpl implements CheckerUserPickService {
    @Autowired
    private CheckerUserPickDao checkerUserPickDao;

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryUserByconditions(CheckerUserPick pick) {
        System.out.println(pick.getIdentify());
        String user_id=pick.getUser_id();
        String user_local_name = pick.getUser_local_name();
        String user_local = "";
        if(!user_local_name.equals("")){
            user_local =userDao.findLocalIdByName(user_local_name);
        }
        String user_name = pick.getUser_name();
        int identify = pick.getIdentify();
        List<User> users=checkerUserPickDao.findUsersByConditions(user_local,user_id,user_name,identify,(pick.getPageNum()-1)*10);
        for (int i=0;i<users.size();i++){
            users.get(i).setId((pick.getPageNum()-1)*10+i+1);
            String id=users.get(i).getUser_local();
            users.get(i).setUser_local_name(userDao.findLocalNameById(id));
        }
        return users;
    }

    @Override
    public int queryUserPagesByConditions(CheckerUserPick pick) {
        String user_id=pick.getUser_id();
        String user_local_name = pick.getUser_local_name();
        String user_local = "";
        if(!user_local_name.equals("")){
            user_local =userDao.findLocalIdByName(user_local_name);
        }
        String user_name = pick.getUser_name();
        int identify = pick.getIdentify();
        int count = checkerUserPickDao.findUsersPageByConditions(user_local,user_id,user_name,identify);
        return count;
    }

    @Override
    public List<String> queryUserLocalNameByLike(String localName) {

        List<String> list =checkerUserPickDao.queryUserLocalNameByLike(localName);
        List<String> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            list2.add(list.get(i).trim());
        }
        return list2;
    }
}
