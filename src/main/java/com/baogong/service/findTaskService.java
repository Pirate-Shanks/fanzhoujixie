package com.baogong.service;

import com.baogong.pojo.CompleteTable;
import com.baogong.pojo.PublicUserTaskPick;
import com.baogong.pojo.TaskItem;
import com.baogong.pojo.UserTaskPick;

import java.util.List;

public interface findTaskService {
    public List<CompleteTable> findById(String id,int page);
    public int findAllNum(String id);

    public List<CompleteTable> findByDate(String id,int page,String date);
    public List<CompleteTable> findByProName(String id,int page,String proName);

    public List<CompleteTable> queryDataByProNameAndDate(String id, int page, String name, String date1,String date2);

    public int findPagesByCheckerId(String user_id);

    List<CompleteTable> findDataByChecker(String user_id, int page);

    public int notPass(String primaryId,String checker_id,String checkerName,String backInfo);

    public int pass(String primaryId,String checker_id,String checkerName);

    public int checkerQueryPagesByProName(String user_id, String name);

   public List<CompleteTable> checkerQueryDataByProName(String user_id, int page, String name);

    public List<CompleteTable> checkerQueryDataByDate(String user_id, int page, String date);

   public int checkerQueryPagesByDate(String user_id, String date);

    public int checkerQueryPagesByProNameAndDate(String user_id, String name, String date);

  public   List<CompleteTable> checkerQueryDataByProNameAndDate(String user_id, int page, String name, String date);

   public int findPagesByTwoDate(String user_id, String date1,String date2);

   public int findPagesByProNameAndTwoDate(String user_id, String name, String date1,String date2);

    public List<CompleteTable> findDataByTwoDate(String user_id, int page,String date1,String date2);

    public  CompleteTable queryDataByPrimaryId(String primaryId);

    public  List<CompleteTable> queryDataByPublicPick(PublicUserTaskPick publicUserTaskPick);
    public  int queryPagesByPublicPick(PublicUserTaskPick publicUserTaskPick);

    public int deleteTask(String primaryId);

   public int managerNotPass(String primaryId,String backInfo);

    public int managerPass(String primaryId);

  public  int deleteOwnTaskByMyself(String primaryId, String user_id, String password);

  public   int queryPagesByUserTaskPick(UserTaskPick userTaskPick);

  public   List<CompleteTable> queryDataByUserTaskPick(UserTaskPick userTaskPick);

    public  List<String> managerQueryAllWorkSpace();
}
