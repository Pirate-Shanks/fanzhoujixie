package com.baogong.dao;

import com.baogong.pojo.LocalInfo;
import com.baogong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    public User findById(@Param("user_id") String user_id);
    public String findLocalNameById(@Param("user_local") String user_local);
    public String findLocalIdByName(@Param("user_local_name") String user_local_name);
    public int insert_user(@Param("user_id")String user_id ,@Param("password")String password);
    public int updateTel(@Param("user_id")String user_id,@Param("tel")String tel);
    public List<User> findUserByPage(int num);
    public int findAllUserPages();
    public List<User> findAll();
    public List<User> findUserByName(String name);
    public List<User> findUserByUserId(String id);
    public List<User> findUserByLocalId(String id);
   public List<User> findNotCheckers();


    public int updateSex(String user_id, String sex);

    public int updatePassword(String user_id, String password);

    public int  updateYearOld(String user_id, String year_old);


    public int updateUserId(@Param("user_id")String user_id, @Param("new_user_id")String new_user_id);

    public int updateUserName(@Param("user_id")String user_id,@Param("user_name")String user_name);

    public int  updateUserPassword(@Param("user_id")String user_id, @Param("password")String user_password);

    public int updateUserLocal(@Param("user_id")String user_id, @Param("user_local")String user_local);

    public User getUserByUserId(@Param("user_id")String user_id);

  public List<String> queryUserSubmitDateByUserId(@Param("user_id")String user_id,@Param("date1") String date1,@Param("date2") String date2);

    public  String queryUserNameByUserId(@Param("user_id")String user_id);

    public  List<LocalInfo> findAllLocalInfo();
}
