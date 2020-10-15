package com.baogong.dao;

import com.baogong.pojo.CheckerItem;
import com.baogong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckerDao {
    public List<String> findAllWorkSection();
    public List<String> findListByName(@Param("name")String name,@Param("id")int check_identify);
    public int itemInsert(CheckerItem item);
    public int updateUserIdentify(String user_id);
    public int cancelUserIdentify(String user_id);

    public int setFrozen(String user_id,String datetime);
    public int cancelFrozen(String user_id);

    public List<User> findAllCheckers();

    public void deleteCheckWorkItem(String user_id);

    public int deleteWorkSpaceCheker(String work_space);

    public int itemDelete(CheckerItem item);

    public int selectItemIsAlive(@Param("work_space")String work_space,@Param("check_identify")int check_identify,@Param("user_id")String user_id);


    public int managerAddLocal(@Param("local_id")String local_id, @Param("local_name")String local_name);

    public int managerAddWorkSpace(@Param("local_id")String local_id, @Param("local_name")String local_name);

    public int  managerDeleteLocal(@Param("local_name")String local_name);

    public int managerDeleteWorkSpace(@Param("local_name")String local_name);

    public int DeleteworkSpace(@Param("local_name")String local_name);
}
