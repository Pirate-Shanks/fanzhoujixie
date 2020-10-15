package com.baogong.dao.logTask;

import com.baogong.pojo.LogTaskItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogTaskDao {
    public int insertTask(LogTaskItem logTaskItem);
      public List<LogTaskItem> findAllOnConditions(@Param("date1") String date1,@Param("date2") String date2,@Param("workSection") String workSection,@Param("page") int page);

   public int findAllPagesOnConditions(@Param("date1") String date1,@Param("date2") String date2,@Param("workSection") String workSection);
}
