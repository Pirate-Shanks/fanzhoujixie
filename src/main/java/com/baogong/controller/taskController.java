package com.baogong.controller;

import com.baogong.dao.TaskDao;
import com.baogong.dao.UserDao;
import com.baogong.dao.WorkSectionDao;
import com.baogong.dao.fzjx.fzjxDao;
import com.baogong.dao.fzjx.taskInfoDao;
import com.baogong.dao.yuancheng.MOCTADao;
import com.baogong.dao.yuancheng.SFCTADao;
import com.baogong.pojo.CheckerPick;
import com.baogong.pojo.CompleteTable;
import com.baogong.pojo.PublicUserTaskPick;
import com.baogong.pojo.UserTaskPick;
import com.baogong.service.CheckerPickService;
import com.baogong.service.findTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class taskController {

    @Autowired
    private SFCTADao sfctaDao;
    @Autowired
    private WorkSectionDao workSectionDao;

    @Autowired
    private MOCTADao moctaDao;

    @Autowired
   private taskInfoDao task;

    @Autowired
    private findTaskService findTask;

    @Autowired
    private fzjxDao fzjx;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private CheckerPickService checkerPickService;

    @ResponseBody
    @RequestMapping("/deleteOwnTask")
    public int deleteOwnTask(@RequestParam("primaryId") String primaryId){
        return findTask.deleteTask(primaryId);
    }

    @ResponseBody
    @RequestMapping("/deleteOwnTaskByMyself")
    public int deleteOwnTaskByMyself(@RequestParam("primaryId") String primaryId ,@RequestParam("user_id") String user_id,@RequestParam("password") String password ){
        return findTask.deleteOwnTaskByMyself(primaryId,user_id,password);
    }


    @ResponseBody
    @RequestMapping("/queryMachineName")
    public List<String> queryMachineName(@RequestParam("queryString") String queryString){
        return task.queryMachineName(queryString);
    }
    @ResponseBody
    @RequestMapping("/queryMachineId")
    public List<String> queryMachineId(@RequestParam("machineName") String machineName){
        return fzjx.robotSelectByMachineName(machineName);
    }


    @ResponseBody
    @RequestMapping("/queryProductId")
    public String queryProductId(@RequestParam("proName") String proName,@RequestParam("proSize")String GG){
        if(proName==""||GG=="")
            return "";
        String productId = fzjx.productIdSelectByName(proName, GG);
        return productId;
    }


    @ResponseBody
    @RequestMapping("/queryProductName")
    public List<String> queryProductName(@RequestParam("queryString") String name){

        return task.queryProduct(name);
    }

    @ResponseBody
    @RequestMapping("/queryProductSize")
    public List<String> queryProductSize(@RequestParam("proName") String name){
        return fzjx.productGGSelectByName(name);
    }
    @ResponseBody
    @RequestMapping("/queryReportType")
    public List<String> queryReportType(@RequestParam("proId") String id,@RequestParam("workType") String workType){
        return moctaDao.findReportTypeByProductId(id);
    }
    @ResponseBody
    @RequestMapping("/queryReportId")
    public List<String> queryReportId(@RequestParam("proId") String id,@RequestParam("reportType") String reportType){
        return moctaDao.findReportTypeByProductIdandWorkType(id,reportType);
    }



    @ResponseBody
    @RequestMapping("/queryWorkProcedure")
    public List<String> queryProcedure(@RequestParam("reportType") String workType,@RequestParam("reportId") String workId,@RequestParam("workTecId") String workTecId,@RequestParam("workSection")String workSection){
        return sfctaDao.gxSelectByProductId(workType,workId,workTecId,workSection);
    }

    //根据工单 找出所有的工艺
    @ResponseBody
    @RequestMapping("/queryWorkTecByReportTypeAndReportId")
    public Map<String,Map<String,List<String>>> queryWorkTec(@RequestParam("reportType") String reportType,@RequestParam("reportId") String reportId){
        return sfctaDao.workTecSelectByGongDan(reportType,reportId);
    }


        //模糊搜索工艺名称
    @ResponseBody
    @RequestMapping("/queryWorkTec")
    public List<String> queryWorkTec(@RequestParam("queryString") String name){


        return task.queryWorkTec(name);
    }
    @ResponseBody
    @RequestMapping("/queryWorkSection")
    public List<String> queryWorkSection(@RequestParam("workTec") String name){
        return fzjx.queryWorkSection(name);
    }



    @ResponseBody
    @RequestMapping("/queryAllDataNum")
    public int queryPages(@RequestParam("user_id") String user_id){
        int count=taskDao.findAllNum(user_id);
        return count;
    }
    @ResponseBody
    @RequestMapping("/queryAllDataByPageNum")
    public List<CompleteTable> queryAllTaskById(@RequestParam("user_id") String user_id, @RequestParam("pageNum") int page){
        return findTask.findById(user_id,page);
    }




    //总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总//总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总
//    @ResponseBody
//    @RequestMapping("/queryPagesByProNameAndDate")
//    public int queryPagesByProNameAndDate(@RequestParam("user_id") String user_id,@RequestParam("proName")String name,@RequestParam("date1")String date1,@RequestParam("date2")String date2){
//        if(date1.equals("") && name.equals("")){
//            return taskDao.findAllNum(user_id);
//        }else if(date1.equals("")&&!name.equals("")){
//            return taskDao.findAllNumByName(user_id,name);
//        }else if(!date1.equals("")&&name.equals("")){
//            return findTask.findPagesByTwoDate(user_id,date1,date2);
//        }else{
//            return findTask.findPagesByProNameAndTwoDate(user_id,name,date1,date2);
//        }
//    }
    //下面两个方法被李冉抛弃
//    @ResponseBody
//    @RequestMapping("/queryPagesByProName")
//    public int queryPagesByProName(@RequestParam("user_id") String user_id,@RequestParam("proName")String name ){
//        return taskDao.findAllNumByName(user_id,name);
//    }
//    @ResponseBody
//    @RequestMapping("/queryPagesByTwoDate")
//    public int queryPagesByTwoDate(@RequestParam("user_id") String user_id,@RequestParam("date1")String date1,@RequestParam("date2")String date2 ){
//        return findTask.findPagesByTwoDate(user_id,date1,date2);
//    }

    //用户查询
    @ResponseBody
    @RequestMapping("/queryPagesByUserTaskPick")
    public int queryPagesByUserTaskPick(@RequestBody UserTaskPick userTaskPick){
        return findTask.queryPagesByUserTaskPick(userTaskPick);
    }




    //总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总//总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总总
//    @ResponseBody
//    @RequestMapping("/queryDataByProNameAndDate")
//    public List<CompleteTable> queryDataByProNameAndDate(@RequestParam("user_id") String user_id,@RequestParam("proName")String name,@RequestParam("date1")String date1,@RequestParam("date2")String date2,int page){
//        if(date1.equals("") && name.equals("")){
//            return findTask.findById(user_id,page);
//        }else if(date1.equals("")&&!name.equals("")){
//            return findTask.findByProName(user_id,page,name);
//        }else if(!date1.equals("")&&name.equals("")){
//            return findTask.findDataByTwoDate(user_id,page,date1,date2);
//        }else{
//            return findTask.queryDataByProNameAndDate(user_id,page,name,date1,date2);
//        }
//
//    }
//    下面的方法被李冉抛弃
//    @ResponseBody
//    @RequestMapping("/queryDataByProName")
//    public List<CompleteTable> queryDateByProName(@RequestParam("user_id") String user_id,@RequestParam("proName")String name, @RequestParam("pageNum")int page){
//        return findTask.findByProName(user_id,page,name);
//    }
//    @ResponseBody
//    @RequestMapping("/queryDataByTwoDate")
//    public List<CompleteTable> queryDataByTwoDate(@RequestParam("user_id") String user_id,@RequestParam("date1")String date1,@RequestParam("date2")String date2, @RequestParam("pageNum")int page ){
//        return findTask.findDataByTwoDate(user_id,page,date1,date2);
//    }
////
//    //用户查询
    @ResponseBody
    @RequestMapping("/queryDataByUserTaskPick")
    public List<CompleteTable> queryDataByUserTaskPick(@RequestBody UserTaskPick userTaskPick ){
        return findTask.queryDataByUserTaskPick(userTaskPick);
    }







    @ResponseBody
    @RequestMapping("/queryDataByPrimaryId")
    public CompleteTable queryDataByPrimaryId(@RequestParam("primaryId") String primaryId ){
        return findTask.queryDataByPrimaryId(primaryId);
    }


    @ResponseBody
    @RequestMapping("/queryDataByPublicPick")
    public List<CompleteTable> queryDataByPublicPick(@RequestBody PublicUserTaskPick publicUserTaskPick){
        return findTask.queryDataByPublicPick(publicUserTaskPick);
    }
    @ResponseBody
    @RequestMapping("/queryPagesByPublicPick")
    public int queryPagesByPublicPick(@RequestBody PublicUserTaskPick publicUserTaskPick){
        return findTask.queryPagesByPublicPick(publicUserTaskPick);
    }





    //下面是审核员操作业务
    //下面是审核员操作业务    //下面是审核员操作业务

    //下面是审核员操作业务    //下面是审核员操作业务    //下面是审核员操作业务    //下面是审核员操作业务

    @ResponseBody
    @RequestMapping("/queryPagesByChecker")
    public int queryPagesByChecker(@RequestParam("user_id") String user_id){

        return findTask.findPagesByCheckerId(user_id);
    }
    @ResponseBody
    @RequestMapping("/queryDataByChecker")
    public List<CompleteTable> queryDataByChecker(@RequestParam("user_id") String user_id, @RequestParam("pageNum") int page){
        return findTask.findDataByChecker(user_id,page);
    }

    @ResponseBody
    @RequestMapping("/notPass")
    public int notPass(@RequestParam("primaryId") String primaryId ,@RequestParam("user_id")String checker_id,@RequestParam("user_name")String checkerName,@RequestParam("backInfo")String backInfo){

        return findTask.notPass(primaryId,checker_id,checkerName,backInfo);
    }

    @ResponseBody
    @RequestMapping("/pass")
    public int pass(@RequestParam("primaryId") String primaryId, @RequestParam("user_id")String checker_id,@RequestParam("user_name")String checkerName){

        return findTask.pass(primaryId,checker_id,checkerName);
    }
    @ResponseBody
    @RequestMapping("/passList")
    public int passList(@RequestParam(value = "selections")String selections,@RequestParam("user_id")String checker_id,@RequestParam("user_name")String checkerName){
        String[] list = selections.split(",");
        for(int i =0;i<list.length;i++){
            if(findTask.pass(list[i],checker_id,checkerName)!=1)
              return 0;
           }
      return 1;
    }

    @ResponseBody
    @RequestMapping("/notPassList")
    public int notPassList(@RequestParam(value = "selections")String selections,@RequestParam("user_id")String checker_id,@RequestParam("user_name")String checkerName,@RequestParam("backInfo")String backInfo){
        String[] list = selections.split(",");
        for(int i =0;i<list.length;i++){
            if(findTask.notPass(list[i],checker_id,checkerName,backInfo)!=1)
                return 0;
        }
        return 1;
    }



    @ResponseBody
    @RequestMapping("/checkerQueryPagesByProName")
    public int checkerQueryPagesByProName(@RequestParam("user_id") String user_id,@RequestParam("proName")String name){

        return findTask.checkerQueryPagesByProName(user_id,name);
    }
    @ResponseBody
    @RequestMapping("/checkerQueryDataByProName")
    public List<CompleteTable> checkerQueryDataByProName(@RequestParam("user_id") String user_id, @RequestParam("pageNum") int page,@RequestParam("proName")String name){
        return findTask.checkerQueryDataByProName(user_id,page,name);
    }


    @ResponseBody
    @RequestMapping("/checkerQueryPagesByDate")
    public int checkerQueryPagesByDate(@RequestParam("user_id") String user_id,@RequestParam("date")String date){

        return findTask.checkerQueryPagesByDate(user_id,date);
    }
    @ResponseBody
    @RequestMapping("/checkerQueryDataByDate")
    public List<CompleteTable> checkerQueryDataByDate(@RequestParam("user_id") String user_id, @RequestParam("pageNum") int page,@RequestParam("date")String date){
        return findTask.checkerQueryDataByDate(user_id,page,date);
    }

    @ResponseBody
    @RequestMapping("/checkerQueryPagesByProNameAndDate")
    public int checkerQueryPagesByProNameAndDate(@RequestParam("user_id") String user_id,@RequestParam("proName")String name,@RequestParam("date")String date){

        return findTask.checkerQueryPagesByProNameAndDate(user_id,name,date);
    }
    @ResponseBody
    @RequestMapping("/checkerQueryDataByProNameAndDate")
    public List<CompleteTable> checkerQueryDataByProNameAndDate(@RequestParam("user_id") String user_id, @RequestParam("pageNum") int page,@RequestParam("proName")String name,@RequestParam("date")String date){
        return findTask.checkerQueryDataByProNameAndDate(user_id,page,name,date);
    }


    @ResponseBody
    @RequestMapping("/checkerPickPages")
    public int checkerPickPages(@RequestBody CheckerPick checkerPick){
       if(checkerPick.getWorkSection().equals("")||checkerPick.getWorkSection()==null||checkerPick.getWorkSection().equals(" "))
           return checkerPickService.checkerFindOwnTaskPages(checkerPick);
       else
            return checkerPickService.queryDataByOwnWorkSectionPages(checkerPick);
    }
    @ResponseBody
    @RequestMapping("/checkerPickData")
    public List<CompleteTable> checkerPickData(@RequestBody CheckerPick checkerPick){
        if(checkerPick.getWorkSection()==null||checkerPick.getWorkSection().equals("")||checkerPick.getWorkSection().equals(" ")) {
            return checkerPickService.checkerFindOwnTask(checkerPick);
        }else {
            return checkerPickService.queryDataByOwnWorkSection(checkerPick);
        }
    }
    @ResponseBody
    @RequestMapping("/weChatCheckerPickTaskSize")
    public int weChatCheckerPickTaskSize(@RequestBody CheckerPick checkerPick){
        checkerPick.setState(0);
        return checkerPickService.checkerFindOwnTaskPages(checkerPick);
    }


    @ResponseBody
    @RequestMapping("/queryMyWorkSection")
    public List<String> checkMyWockSection(@RequestParam("user_id") String user_id){
        return checkerPickService.findMyOwnSection(user_id);
    }




//    @ResponseBody
//    @RequestMapping("/queryDataByOwnWorkSection")
//    public List<CompleteTable> queryDataByOwnWorkSection(@RequestParam("user_id") String user_id,@RequestParam("workSection") String workSection,@RequestParam("date1") String date1,@RequestParam("date2")String date2,@RequestParam("proName")String proName){
//        return checkerPickService.queryDataByOwnWorkSection(user_id,workSection,date1,date2,proName);
//    }



    //管理员审核通过写入数据库
    @ResponseBody
    @RequestMapping("/managerCheckerPickPages")
    public int managerCheckerPickPages(@RequestBody CheckerPick checkerPick){
        if(checkerPick.getWorkSection().equals(" "))
            checkerPick.setWorkSection("");
        return checkerPickService.managerCheckerPickPages(checkerPick);
    }
    @ResponseBody
    @RequestMapping("/managerCheckerPickData")
    public List<CompleteTable> managerCheckerPickData(@RequestBody CheckerPick checkerPick){
        if(checkerPick.getWorkSection().equals(" "))
            checkerPick.setWorkSection("");
       return checkerPickService.managerCheckerPickData(checkerPick);
    }
    @ResponseBody
    @RequestMapping("/managerNotPass")
    public int notPass(@RequestParam("primaryId") String primaryId,@RequestParam("backInfo")String backInfo){

        return findTask.managerNotPass(primaryId,backInfo);
    }
    @ResponseBody
    @RequestMapping("/managerPass")
    public int pass(@RequestParam("primaryId") String primaryId){
        return findTask.managerPass(primaryId);
    }

    @ResponseBody
    @RequestMapping("/managerNotPassList")
    public int managerNotPassList(@RequestParam(value = "selections")String selections,@RequestParam("backInfo")String backInfo){
        String[] list = selections.split(",");
        for(int i =0;i<list.length;i++){
            if(findTask.managerNotPass(list[i],backInfo)!=1)
                return 0;
        }
        return 1;
    }
    @ResponseBody
    @RequestMapping("/managerPassList")
    public int managerPassList(@RequestParam(value = "selections")String selections){
        String[] list = selections.split(",");
        int count=0;
        for(int i =0;i<list.length;i++){
            if(findTask.managerPass(list[i])==1)
                count++;
        }
        return count;
    }

    @ResponseBody
    @RequestMapping("/managerQueryAllWorkSpace")
    public List<String> managerQueryAllWorkSpace(){

        return findTask.managerQueryAllWorkSpace();
    }



}
