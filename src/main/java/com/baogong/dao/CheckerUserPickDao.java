package com.baogong.dao;

import com.baogong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckerUserPickDao {
    public List<User> findUsersByConditions(@Param("user_local")String user_local,@Param("user_id")String user_id, @Param("user_name")String user_name,@Param("identify") int identify,@Param("page")int pageNum);

    public int findUsersPageByConditions(@Param("user_local")String user_local, @Param("user_id")String user_id,@Param("user_name")String user_name,@Param("identify") int identify);

    public List<String> queryUserLocalNameByLike(@Param("user_local_name")String localName);
}
