package com.baogong.controller;

import com.baogong.Utils.IsAllowedUtils;
import com.baogong.dao.ManagerControlDao;
import com.baogong.dao.UserDao;
import com.baogong.pojo.*;
import com.baogong.service.CheckerUserPickService;
import com.baogong.service.loginService;
import com.baogong.service.submitService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class userController {

    @Autowired
    private IsAllowedUtils isAllowedUtils;
    @Autowired
    private CheckerUserPickService checkerUserPickService;

    @Autowired
    private loginService loginServer;

    @Autowired
    private submitService submitServer;

    @Autowired
    private ManagerControlDao managerControlDao;
    @Autowired
    private UserDao userDao;
    @ResponseBody
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user1, HttpServletRequest request) throws JSONException {
        Map<String, Object> map = new HashMap<>();
        User user = loginServer.login(user1);
        int result = 0;
        if(user.getIdentify()==0){
            if(!isAllowedUtils.isAllowedLogin()){
                result = -2;
                map.put("result", result);
                return map;
            }
        }
        if (user == null) {
            result = 0;
        } else {
            if (user.getPassword().equals(user1.getPassword())) {
                result = 1;
                if (user.getIdentify() == -1) {
                    result = -1;
                }
            }else {
                result = 2;
            }
        }
            map.put("result", result);
            map.put("user", user);
            request.getSession().setAttribute("user",user);
            return map;
        }

    @ResponseBody
    @RequestMapping("/submit")
    public int submit(@RequestBody Table table){
        if(!isAllowedUtils.isAllowedLogin()){
            return -2;
        }
        SystemInfo info =managerControlDao.getSystemInfo();
        String code = info.getIscontrol();
        int length=0;
        if(code.equals("1")){
           if(isAllowedUtils.isAllowedSubmit(table.getDate())){
               try{
                   length=submitServer.submit(table);
               }catch (Exception e) {
                   System.out.println(e);
                   return 0;
               }
           }else {
               return -1;
           }
        }else {
            try{
                length=submitServer.submit(table);
            }catch (Exception e) {
                System.out.println(e);
                return 0;
            }
        }
        return length;
    }

    @ResponseBody
    @RequestMapping("/updateUserId")
    public int updateUserId(@RequestParam("user_id") String user_id,@RequestParam("new_user_id") String new_user_id){
        try{
            userDao.updateUserId(user_id,new_user_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    @ResponseBody
    @RequestMapping("/updateUserName")
    public int updateUserName(@RequestParam("user_id") String user_id,@RequestParam("user_name") String user_name){
        try{
            userDao.updateUserName(user_id,user_name);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    @ResponseBody
    @RequestMapping("/queryUserNameByUserId")
    public String queryUserNameByUserId(@RequestParam("user_id") String user_id){
        try{
            String userName="";
            if(userDao.queryUserNameByUserId(user_id)!=null){
                userName=userDao.queryUserNameByUserId(user_id);
            }
            return userName;
        }catch (Exception e){
            return "";
        }

    }
//    @ResponseBody
//    @RequestMapping("/updateUserPassword")
//    public int updateUserPassword(@RequestParam("user_id") String user_id,@RequestParam("password") String password){
//        try{
//            System.out.println(user_id+"  "+password);
//            userDao.updateUserPassword(user_id,password);
//            return 1;
//        }catch (Exception e){
//            System.out.println(e);
//            return 0;
//        }
//
//    }

    @ResponseBody
    @RequestMapping("/updateUserLocal")
    public int  updateUserLocal(@RequestParam("user_id") String user_id,@RequestParam("user_local") String user_local){
//       Map<String,Object> map = new HashMap<>();
        String localName= userDao.findLocalNameById(user_local);
        if(localName==null){
//            map.put("success",0);
            return 0;
        }else{
            userDao.updateUserLocal(user_id,user_local);
//            map.put("success",1);
//            map.put("user_local_name",localName);
            return 1;
        }
    }



    //更新用户电话号码
    @ResponseBody
    @RequestMapping("/updateTelephone")
    public int updateTelephone(@RequestParam("user_id") String user_id,@RequestParam("user_telephone") String tel){
        try{
            userDao.updateTel(user_id,tel);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }


    //更新性别
    @ResponseBody
    @RequestMapping("/updateSex")
    public int updateSex(@RequestParam("user_id") String user_id,@RequestParam("user_sex") String sex){
        try{
            userDao.updateSex(user_id,sex);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
    @ResponseBody
    @RequestMapping("/updatePassword")
    public int updatePassword(@RequestParam("user_id") String user_id,@RequestParam("password") String password){
        try{
            userDao.updatePassword(user_id,password);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
    @ResponseBody
    @RequestMapping("/updateYearOld")
    public int updateYearOld(@RequestParam("user_id") String user_id,@RequestParam("year_old") String year_old){
        try{
            userDao.updateYearOld(user_id,year_old);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }




    @ResponseBody
    @RequestMapping("/updateTable")
    public int updateTable(@RequestBody CompleteTable table){
        try{
            submitServer.updateTask(table);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }

    }

    @ResponseBody
    @RequestMapping("/queryUserPagesByConditions")
    public int queryUserPagesByConditions(@RequestBody CheckerUserPick pick){
     return checkerUserPickService.queryUserPagesByConditions(pick);

    }

    @ResponseBody
    @RequestMapping("/queryUserByConditions")
    public List<User> queryUserByconditions(@RequestBody CheckerUserPick pick){
       return checkerUserPickService.queryUserByconditions(pick);
    }

    @ResponseBody
    @RequestMapping("/queryUserLocalNameByLike")
    public List<String> queryUserLocalNameByLike(@RequestParam("queryString")String localName){

        return checkerUserPickService.queryUserLocalNameByLike(localName);
    }

    @ResponseBody
    @RequestMapping("/getUserByUserId")
    public User getUserByUserId(@RequestParam("user_id")String user_id){
        User user= userDao.findById(user_id);
        if(user!=null){
            user.setUser_local_name(userDao.findLocalNameById(user.getUser_local()));}
        return user;
    }

    @ResponseBody
    @RequestMapping("/queryUserSubmitDateByUserId")
    public List<String> queryUserSubmitDateByUserId(@RequestParam("user_id")String user_id,@RequestParam("date1")String date1,@RequestParam("date2")String date2){
        return loginServer.queryUserSubmitDateByUserId(user_id,date1,date2);
    }

}
