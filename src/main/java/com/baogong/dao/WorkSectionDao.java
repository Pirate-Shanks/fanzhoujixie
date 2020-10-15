package com.baogong.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkSectionDao {
    public String findWorkSpaceName(String id);
    public String findWorkSpaceId(String name);

    public List<String> managerQueryAllWorkSpace();
}
