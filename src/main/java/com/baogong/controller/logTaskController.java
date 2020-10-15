package com.baogong.controller;

import com.baogong.Utils.ChangeC3p0PoolInfo;
import com.baogong.dao.ManagerControlDao;
import com.baogong.dao.logTask.DatabaseDao;
import com.baogong.dao.yuancheng.TBDao;
import com.baogong.pojo.*;
import com.baogong.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class logTaskController {

    @Autowired
    private ManagerControlDao managerControlDao;
    @Autowired
    private TBDao tbDao;
    @Autowired
    private ChangeC3p0PoolInfo changeC3p0PoolInfo;
    @Autowired
    private CheckerService checkerService;
    @Autowired
    private DatabaseDao databaseDao;
    @ResponseBody
    @RequestMapping("/queryLogDataOnConditions")
    public List<LogTaskItem> queryLogDataOnConditions(@RequestBody CheckerLogPick checkerLogPick){
        return checkerService.queryLogOnConditions(checkerLogPick);
    }
    @ResponseBody
    @RequestMapping("/queryLogPagesOnConditions")
    public int queryLogPagesOnConditions(@RequestBody CheckerLogPick checkerLogPick){
        return checkerService.queryLogPagesOnConditions(checkerLogPick);
    }

    @ResponseBody
    @RequestMapping("/updateIp")
    public int updateIp(@RequestParam("ip") String ip){
        try{
            databaseDao.updateIp(ip);
            changeC3p0PoolInfo.Change(1,ip);
             return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/updatePort")
    public int updatePort(@RequestParam("port") String port){
        try{
            databaseDao.updatePort(port);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/updateDatabaseName")
    public int updateDatabaseName(@RequestParam("databaseName") String databaseName){
        try{
            databaseDao.updateDatabaseName(databaseName);
            changeC3p0PoolInfo.Change(2,databaseName);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/updateDatabaseUserName")
    public int updateDatabaseUserName(@RequestParam("userName") String userName){
        try{
            databaseDao.updateUserName(userName);
            changeC3p0PoolInfo.Change(3,userName);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/updateDatabasePassword")
    public int updateDatabasePassword(@RequestParam("password") String password){
        try{
            databaseDao.updatePassword(password);
            changeC3p0PoolInfo.Change(4,password);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("/findDatabaseInfo")
    public DatabaseInfo findDatabaseInfo(){
        return databaseDao.findDatabaseInfo();
    }

    @ResponseBody
    @RequestMapping("/findAllDatabaseTBInfo")
    public List<DatabaseTBinfo> findAllDatabaseTBInfo(){
        return databaseDao.findAllDatabaseTBInfo();
    }


    @ResponseBody
    @PostMapping("/TBdataBaseInfoByQueryString")
    public int TBdataBase(@RequestBody String databaseName){

        String[] list=databaseName.split(":");
        String name=list[1].substring(1,list[1].length()-2);
        try{
        if(name.equals("all")){
            tbDao.INVMB_TB();
//            tbDao.CMSME_TB();
            tbDao.CMSMW_TB();
            tbDao.CMSMX_TB();
            tbDao.CMSMV_TB();
        }else if(name.equals("INVMB")){
            tbDao.INVMB_TB();
        }else if(name.equals("CMSMW")){
            tbDao.CMSMW_TB();
        }else if(name.equals("CMSMX")){
            tbDao.CMSMX_TB();
        }else if(name.equals("CMSMV")){
            tbDao.CMSMV_TB();
        }else if(name.equals("CMSME")){
            tbDao.CMSME_TB();
        }else if(name.equals("CMSMD")){
            tbDao.CMSMD_TB();
        } else return 0;}catch (Exception e){
            return 0;
        }
        return 1;
      //  return checkerService.TBdataBaseInfoByQueryString(databaseName);
    }

    @ResponseBody
    @PostMapping("/updateSystemInfoButton")
    public int updateSystemInfo(@RequestBody SystemInfo info){
        try{
            managerControlDao.updateSystemInfoButton(info);
            return  1;
        }catch (Exception e){
            return 0;
        }
    }
    @ResponseBody
    @PostMapping("/updateSystemInfoTimePicker")
    public int updateSystemInfoTimePicker(@RequestBody SystemInfo info){
        try{
            managerControlDao.updateSystemInfoTimePicker(info);
            return  1;
        }catch (Exception e){
            return 0;
        }
    }


    @ResponseBody
    @GetMapping("/getSystemInfo")
    public SystemInfo getSystemInfo(){
        try{
           return managerControlDao.getSystemInfo();
        }catch (Exception e){
            return null;
        }
    }


}
