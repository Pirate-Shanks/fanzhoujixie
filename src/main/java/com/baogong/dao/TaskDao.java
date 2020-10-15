package com.baogong.dao;

import com.baogong.pojo.CheckerItem;
import com.baogong.pojo.CompleteTable;
import com.baogong.pojo.TaskItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskDao {

    public int taskInsert(TaskItem taskItem);
    public int taskUpdate(TaskItem taskItem);
    public List<TaskItem> findById(@Param("id")String id, @Param("page")int page);

    public int findAllNum(String id);

    public List<TaskItem> findByDate(@Param("id")String id, @Param("page")int page,@Param("date") String date);
    public int findAllNumBydate(@Param("id")String id,@Param("date") String date);

    public List<TaskItem> findByProName(@Param("id")String id, @Param("page")int page,@Param("name") String name);
    public int findAllNumByName(@Param("id")String id,@Param("name") String name);

    public int findPagesByProNameAndDate(@Param("id")String id,@Param("name") String name,@Param("date") String date);

    public List<CheckerItem> findCheckItemByUserId(String user_id);
    public CheckerItem findCheckItemByUserIdAndWorkSection(@Param("user_id")String user_id,@Param("workSection")String workSection);
    public List<TaskItem> findTaskItemByWorkSpace(String workspace);

    public int updateState(@Param("state")int state,@Param("primaryId")String primaryId);

    public int findWorkSpaceIdentify(String workSpace);

    public TaskItem queryDataByPrimaryId(String primaryId);

    List<Double> findTodayWorkHour(@Param("user_id")String user_id,@Param("date") String date);

    public int findpagesByTwoDate(@Param("user_id")String user_id,@Param("date1")String s, @Param("date2")String s1);

    public int findPagesByProNameAndTwoDate(@Param("user_id")String user_id, @Param("proName")String name, @Param("date1")String s,@Param("date2") String s1);

   public List<TaskItem> findDateByTwoDate(@Param("user_id")String user_id,@Param("page")int page,@Param("date1") String s,@Param("date2") String s1);
    public List<TaskItem> findDataByProNameAndDate(@Param("user_id")String id, @Param("page")int page,@Param("name") String name,@Param("date1") String date1, @Param("date2") String date2);

    //查找某个工单剩余可报数量
    public Double findRemainAcount(@Param("reportType")String reportType,@Param("reportId")String reportId,@Param("workProcedure")String workProcedure);


   public int queryPagesByPublicPick(@Param("user_name")String user_name,@Param("proName") String proName, @Param("date1")String date1, @Param("date2")String date2, @Param("workTec")String workTec);

    public List<TaskItem> queryDataByPublicPick(@Param("user_name")String user_name,@Param("proName") String proName, @Param("date1")String date1, @Param("date2")String date2,@Param("workTec")String workTec,@Param("page") int page);

   public int deleteTaskByWorkIdAndBeTweenDate(@Param("primaryId")String primaryId);

   public List<TaskItem> findTodayTaskItemSize(@Param("date")String date,@Param("workSection")String workSection,@Param("workType")String workType);

  public   int findAllToday(@Param("date")String date);

  public int findIsHavaChcker(@Param("workSection")String workSection);

   public int deleteOwnTaskByMyself(@Param("primaryId")String primaryId,@Param("user_id") String user_id);

  public   int queryPagesByUserTaskPick(@Param("user_id")String user_id, @Param("date1")String date1, @Param("date2")String date2, @Param("proName")String proName);

 public  List<TaskItem> queryDataByUserTaskPick(@Param("user_id")String user_id, @Param("date1")String date1, @Param("date2")String date2, @Param("proName")String proName,  @Param("page")int page);

    public int findToDayXuhaoByWorkId(@Param("workId")String workId);

   public String findTodayMaxWorkId(@Param("date")String date);

    public String findToDayMaxXuhaoByWorkId(@Param("workId")String workId);

    public int updateItem(@Param("workId")String workId, @Param("xuhao")String xuhao, @Param("primaryId")String primaryId);

    public int setBackInfo(@Param("primaryId")String primaryId,@Param("message") String message);
}
