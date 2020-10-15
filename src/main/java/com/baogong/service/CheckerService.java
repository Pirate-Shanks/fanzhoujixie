package com.baogong.service;

import com.baogong.pojo.CheckerLogPick;
import com.baogong.pojo.Checkers;
import com.baogong.pojo.LogTaskItem;
import com.baogong.pojo.User;

import java.util.List;

public interface CheckerService {
    public List<Checkers> findAllWorkSection();
    public int updateIdentify(String user_id);
   public int cancelIdentify(String user_id);
   public int setFrozen(String user_id);
    public int cancelFrozen(String user_id);
   public List<User> findAllCheckers();
   public int deleleWorkSpaceChecker(String work_space);

   public int setWorkSpaceChecker(String work_space,int check_identify,String user_id);

   public int deleteWorkSpaceChecker(String work_space, int check_identify, String user_id);

    public  List<User> findNotCheckers();

    public List<LogTaskItem> queryLogOnConditions(CheckerLogPick checkerLogPick);

    public int queryLogPagesOnConditions(CheckerLogPick checkerLogPick);

   public int managerAddWorkSpace(String local_id, String local_name);

    public  int managerDeleteWorkSpace(String local_name);
}
