package com.baogong.dao;

import com.baogong.pojo.SystemInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerControlDao {
    public int updateSystemInfoButton(SystemInfo systemInfo);

    public SystemInfo getSystemInfo();

    public int updateSystemInfoTimePicker(SystemInfo systemInfo);
}
