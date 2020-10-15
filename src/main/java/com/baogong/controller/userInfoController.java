package com.baogong.controller;


import com.baogong.dao.TaskDao;
import com.baogong.pojo.LocalInfo;
import com.baogong.pojo.TaskItem;
import com.baogong.pojo.User;
import com.baogong.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class userInfoController {


    @Autowired
    private FindUserService findUserService;

    @ResponseBody
    @RequestMapping("/queryTodayWorkHour")
    public Double queryTodayWorkHour(@RequestParam("user_id") String user_id,@RequestParam("date") String date){
//        System.out.println(user_id + " "+ date);
//        System.out.println(findUserService.findTodayWorkHour(user_id,date));
        return findUserService.findTodayWorkHour(user_id,date);
    }


    @ResponseBody
    @RequestMapping("/queryUserPages")
    public int queryUserPages(){

        return findUserService.findAllUserPages();
    }
    @ResponseBody
    @RequestMapping("/queryUserData")
    public List<User> queryUserDate(@RequestParam("pageNum") int page){
       return findUserService.findUserByPage(page);
    }

    @ResponseBody
    @RequestMapping("/queryAllUsers")
    public List<User> queryUserAll(){
        return findUserService.findUserAll();
    }

    @ResponseBody
    @RequestMapping("/queryUsersByName")
    public List<User> queryUsersByName(@RequestParam("queryString") String name){

        return findUserService.findUserByName(name);
    }

    @ResponseBody
    @RequestMapping("/queryUsersByUserId")
    public List<User> queryUsersByUserId(@RequestParam("queryString") String user_id){

        return findUserService.findUserByUser_id(user_id);
    }

    @ResponseBody
    @RequestMapping("/queryUsersByLocalId")
    public List<User> queryUsersByLocalId(@RequestParam("queryString") String local_id){
        return findUserService.findUserByUserLocal(local_id);
    }


    //查询用户最大可报工数量
    @ResponseBody
    @RequestMapping("/queryUserTransferNum")
    public Double queryUsersTransferNum(@RequestParam("reportType") String reportType,@RequestParam("reportId") String reportId,@RequestParam("workProcedure") String workProcedure,@RequestParam("transferNum")Double transferNum){

        return findUserService.findIfTransferNum(reportType,reportId,workProcedure,transferNum);
    }








    @ResponseBody
    @RequestMapping("/queryUserPagesByWorkSection")
    public int queryUserPagesByWorkSection(@RequestParam("work_section")String work_section){

        return 0;
    }
    @ResponseBody
    @RequestMapping("/queryUserDateByWorkSection")
    public List<User> queryUserDateByWorkSection(@RequestParam("user_id") String user_id, @RequestParam("pageNum") int page, @RequestParam("proName")String name, @RequestParam("date")String date){

        return null;
    }

    @ResponseBody
    @RequestMapping("/queryAllLocalName")
    public List<LocalInfo> queryAllLocalName(){
      return findUserService.findAllLocalInfo();
    }


}
