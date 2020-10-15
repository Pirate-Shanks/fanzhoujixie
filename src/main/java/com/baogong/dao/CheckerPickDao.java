package com.baogong.dao;

import com.baogong.pojo.CheckerItem;
import com.baogong.pojo.TaskItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CheckerPickDao {
   public List<TaskItem> checkerFindOwnTask(@Param("worksection")String workSection,@Param("date1") String date1,@Param("date2") String date2,@Param("proName") String proName,@Param("user_name")String employeeName,@Param("identify")int identify,@Param("page")int page,@Param("state")int state);
  public List<TaskItem> managerCheckerFindonTask(@Param("date1") String date1,@Param("date2") String date2,@Param("proName") String proName,@Param("user_name")String employeeName,@Param("worksection")String workSection,@Param("page")int page,@Param("state")int state);
    public int managerCheckerFindonTaskPages(@Param("date1") String date1,@Param("date2") String date2,@Param("proName") String proName,@Param("user_name")String employeeName,@Param("worksection")String workSection,@Param("state")int state);

    public  int checkerPagesFindOwnTask(@Param("worksection")String workSection,@Param("date1") String date1,@Param("date2") String date2,@Param("proName") String proName,@Param("user_name")String employeeName,@Param("identify")int identify,@Param("state")int state);


    public List<TaskItem> checkerFindOwnTaskAll(@Param("checkerItems")List<CheckerItem> checkerItems, @Param("date1") String date1, @Param("date2") String date2, @Param("proName") String proName, @Param("user_name")String employeeName,  @Param("page")int page, @Param("state")int state);

    public int checkerFindOwnTaskAllPages(@Param("checkerItems")List<CheckerItem> checkerItems, @Param("date1") String date1, @Param("date2") String date2, @Param("proName") String proName, @Param("user_name")String employeeName,@Param("state")int state);
}
