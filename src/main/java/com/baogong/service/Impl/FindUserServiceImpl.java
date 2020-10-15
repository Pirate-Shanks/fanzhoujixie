package com.baogong.service.Impl;

import com.baogong.dao.TaskDao;
import com.baogong.dao.UserDao;
import com.baogong.dao.yuancheng.SFCTADao;
import com.baogong.dao.yuancheng.SFCTEDao;
import com.baogong.pojo.LocalInfo;
import com.baogong.pojo.User;
import com.baogong.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FindUserServiceImpl implements FindUserService {

    @Autowired
    private SFCTADao sfctaDao;
    @Autowired
    private SFCTEDao sfcteDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TaskDao taskDao;
    @Override
    public List<User> findUserByPage(int page) {
        List<User> userList= userDao.findUserByPage((page-1)*10);
        List<User> response = new ArrayList<>();
        for(int i=0;i<userList.size();i++) {
                userList.get(i).setId((page-1)*10+i + 1);
                String local_name = userDao.findLocalNameById(userList.get(i).getUser_local());
                userList.get(i).setUser_local_name(local_name);
                response.add(userList.get(i));
        }
        return response;
    }

    @Override
    public int findAllUserPages() {
        return userDao.findAllUserPages();
    }

    @Override
    public List<User> findUserAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public List<User> findUserByUser_id(String id) {
        return userDao.findUserByUserId(id);
    }

    @Override
    public List<User> findUserByUserLocal(String id) {
        return userDao.findUserByLocalId(id);
    }

    @Override
    public Double findTodayWorkHour(String user_id, String date) {
        try {
           List<Double> list= taskDao.findTodayWorkHour(user_id, date);
           double count=0;
            for (Double I:list) {
                count+=I;
            }return count;
        }catch (Exception e){
            return 0.0;
        }

    }

    @Override
    public Double findIfTransferNum(String reportType, String reportId, String workProcedure, Double transferNum) {
       if(reportType==""||reportId==""||workProcedure==""){
           return -1.0;
       }
        Double s=sfctaDao.getMaxProductHave(reportType,reportId);
        Double l=taskDao.findRemainAcount(reportType,reportId,workProcedure);
        Double l2 = sfcteDao.remoteFindRemainAcount(reportType,reportId,workProcedure);
        if(l==null){
            l=0.0;
        }
        if(l2==null){
            l2=0.0;
        }
        Double remain = s-l-l2;
        return remain;
    }

    @Override
    public List<LocalInfo> findAllLocalInfo() {
        return userDao.findAllLocalInfo();
    }
}
