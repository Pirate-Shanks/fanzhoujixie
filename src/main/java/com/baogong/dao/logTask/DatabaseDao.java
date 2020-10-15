package com.baogong.dao.logTask;

import com.baogong.pojo.DatabaseInfo;
import com.baogong.pojo.DatabaseTBinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DatabaseDao {
    public int updateIp(@Param("ip") String ip);
    public int updatePort(@Param("port")String port);
    public int updateDatabaseName(@Param("databaseName")String databaseName);
    public int updateUserName(@Param("userName")String userName);
    public int updatePassword(@Param("password")String password);
    public DatabaseInfo findDatabaseInfo();

    public List<DatabaseTBinfo> findAllDatabaseTBInfo();
}
