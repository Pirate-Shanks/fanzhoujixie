package com.baogong.dao;

import com.baogong.pojo.DatabaseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConnectionUpdateDao {
  public DatabaseInfo findDatabaseInfo();
}
