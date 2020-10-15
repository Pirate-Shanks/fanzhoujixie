package com.baogong.service;

import com.baogong.pojo.LocalInfo;
import com.baogong.pojo.User;

import java.util.List;
import java.util.Map;

public interface FindUserService {
    public List<User> findUserByPage(int page);
    public int findAllUserPages();
    public List<User> findUserAll();

    public List<User> findUserByName(String name);
    public List<User> findUserByUser_id(String id);
    public List<User> findUserByUserLocal(String id);

   public Double findTodayWorkHour(String user_id, String date);

   public Double findIfTransferNum(String reportType, String reportId, String workProcedure,Double transferNum);

    public List<LocalInfo> findAllLocalInfo();
}
