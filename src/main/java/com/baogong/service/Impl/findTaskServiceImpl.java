package com.baogong.service.Impl;

import com.baogong.Utils.PrimaryGenerater;
import com.baogong.dao.TaskDao;
import com.baogong.dao.UserDao;
import com.baogong.dao.WorkSectionDao;
import com.baogong.dao.logTask.LogTaskDao;
import com.baogong.dao.yuancheng.SFCTEDao;
import com.baogong.pojo.*;
import com.baogong.service.findTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class findTaskServiceImpl implements findTaskService {


    @Autowired
    private SFCTEDao sfcteDao;
    @Autowired
    private LogTaskDao logTaskDao;
    @Autowired
    private TaskDao taskDao;

    @Autowired
    private WorkSectionDao workSectionDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<CompleteTable> findById(String id,int page) {
        List<TaskItem> list= taskDao.findById(id,(page-1)*10);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);
            CompleteTable completeTable =new CompleteTable();
            completeTable.setId((page-1)*10+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }
        return completeTables;
    }

    @Override
    public int findAllNum(String id) {
        return taskDao.findAllNum(id);
    }


    public List<CompleteTable> findByDate(String id,int page,String date) {
        List<TaskItem> list= taskDao.findByDate(id,(page-1)*10,date);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);
            CompleteTable completeTable =new CompleteTable();
            completeTable.setId((page-1)*10+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }

        return completeTables;
    }

    public List<CompleteTable> findByProName(String id,int page,String proName) {
        List<TaskItem> list= taskDao.findByProName(id,(page-1)*10,proName);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);

            CompleteTable completeTable =new CompleteTable();
            completeTable.setId((page-1)*10+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }

        return completeTables;
    }



//    @Override
//    public List<CompleteTable> queryDataByProNameAndDate(String id, int page, String name, String date) {
//        List<TaskItem> list= taskDao.queryDataByProNameAndDate(id,(page-1)*10,name,date);
//        List<CompleteTable> completeTables =new ArrayList<>();
//        for(int i = 0;i<list.size();i++){
//            TaskItem taskItem =list.get(i);
//            CompleteTable completeTable =new CompleteTable();
//            completeTable.setId((page-1)*10+i+1);
//            completeTable.setUser_name(taskItem.getUser_name());
//            completeTable.setUser_id(taskItem.getTE004());
//            completeTable.setWorkType(taskItem.getTE001());
//            completeTable.setWorkId(taskItem.getTE002());
//            completeTable.setReportType(taskItem.getTE006());
//            completeTable.setReportId(taskItem.getTE007());
//            completeTable.setMacName(taskItem.getMac_name());
//            completeTable.setMacId(taskItem.getTE005());
//            completeTable.setProName(taskItem.getTE018());
//            completeTable.setProSize(taskItem.getTE019());
//            completeTable.setWorkTec(taskItem.getWork_tec_name());
//            completeTable.setTransferType(taskItem.getTE010());
//            completeTable.setTransferNum(taskItem.getTE011());
//            completeTable.setCalType(taskItem.getTE030());
//            completeTable.setDate(taskItem.getDate());
//            completeTable.setState(taskItem.getTE014());
//            completeTable.setWork_hour(taskItem.getWork_hour());
//            completeTable.setWorkProcedure(taskItem.getTE008());
//            completeTables.add(completeTable);
//        }
//
//        return completeTables;
//    }

    @Override
    public int findPagesByCheckerId(String user_id) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem taskItem: taskItemByWorkSpace) {
                if(item.getCheck_identify()-taskItem.getTE014()>1){
                    continue;
                }else{
                   length++;
                }
        }
        }
    return length;
    }

    @Override
    public List<CompleteTable> findDataByChecker(String user_id, int page) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        List<CompleteTable> completeTables =new ArrayList<>();
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem taskItem: taskItemByWorkSpace) {
                if(item.getCheck_identify()-taskItem.getTE014()>1){
                    continue;
                }else{
                CompleteTable completeTable =new CompleteTable();
                completeTable.setUser_name(taskItem.getUser_name());
                completeTable.setUser_id(taskItem.getTE004());
                completeTable.setWorkType(taskItem.getTE001());
                completeTable.setWorkId(taskItem.getTE002());
                    completeTable.setWorkNum(taskItem.getTE003());
                completeTable.setReportType(taskItem.getTE006());
                completeTable.setReportId(taskItem.getTE007());
                completeTable.setMacName(taskItem.getMac_name());
                completeTable.setMacId(taskItem.getTE005());
                completeTable.setProName(taskItem.getTE018());
                completeTable.setProSize(taskItem.getTE019());
                completeTable.setWorkTec(taskItem.getWork_tec_name());
                completeTable.setFailNum(taskItem.getTE010());
                completeTable.setTransferNum(taskItem.getTE011());
                completeTable.setCalType(taskItem.getTE030());
                completeTable.setDate(taskItem.getDate());
                completeTable.setMac_hour(taskItem.getMac_hour());
                    completeTable.setProId(taskItem.getTE017());
                    completeTable.setPrimaryId(taskItem.getPrimaryId());
                    completeTable.setWorkSection(taskItem.getWork_section());
                    completeTable.setWorkSectionName(taskItem.getWork_section_name());
                    completeTable.setWorkTecId(taskItem.getTE009());
                    completeTable.setInfo(taskItem.getTE015());
                    completeTable.setBack_info(taskItem.getBack_info());
                    completeTable.setWorkTime(taskItem.getWork_time());
                if((item.getCheck_identify()-taskItem.getTE014())==1){
                completeTable.setState(0);
                }else {
                    completeTable.setState(1);
                }
                completeTable.setWork_hour(taskItem.getWork_hour());
                completeTable.setWorkProcedure(taskItem.getTE008());
                    completeTable.setUser_local_name(taskItem.getUser_local_name());

                completeTables.add(completeTable);
            }
            }
        }
        List<CompleteTable> completeTables2 =new ArrayList<>();
        Collections.sort(completeTables);
        for(int i = (page-1)*10;i<page*10;i++){
            if(i<completeTables.size()){
                completeTables.get(i).setId(i+1);
            completeTables2.add(completeTables.get(i));
            }
        }
        return completeTables2;
    }

    @Override
    public int notPass(String primaryId,String checker_id,String checkerName,String backInfo) {
        try{

            TaskItem item = taskDao.queryDataByPrimaryId(primaryId);
//            User user = userDao.findById(item.getTE004());
//            String work_sectionId = item.getWork_section();
            String spaceName =item.getUser_local_name();
            int workIdentify = taskDao.findWorkSpaceIdentify(spaceName);
            if (item.getTE014()==6||item.getTE014()==workIdentify) {
                return 0;
            } else {
                taskDao.setBackInfo(primaryId,backInfo);
                taskDao.updateState(-1,primaryId);
            }
            //下面是插入日志
            LogTaskItem logTaskItem = new LogTaskItem();
            logTaskItem.setChecker_id(checker_id);
            logTaskItem.setChecker_name(checkerName);
            logTaskItem.setWorkId(item.getTE006());
            logTaskItem.setWorkType(item.getTE001());
            logTaskItem.setWorkNum(item.getTE007());
            SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date time=new Date();
            String times=timeFormat.format(time);
            logTaskItem.setCheckType(0);
            logTaskItem.setDate(times);
            logTaskItem.setProName(item.getTE018());
            logTaskItem.setUser_id(item.getTE004());
            //logTaskItem.setWorkSection(workSectionDao.findWorkSpaceName(item.getWork_section()));
//            logTaskItem.setWorkSection(item.getWork_section_name());
            logTaskItem.setWorkSection(spaceName);
            logTaskItem.setUser_name(item.getUser_name());
            logTaskDao.insertTask(logTaskItem);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public int pass(String primaryId,String checker_id,String checkerName) {
        //找出该工艺的表单
        try {
            TaskItem item = taskDao.queryDataByPrimaryId(primaryId);
//            User user = userDao.findById(item.getTE004());
//            String work_sectionId = item.getWork_section();
            String spaceName = item.getUser_local_name();
            //下面是插入日志
            LogTaskItem logTaskItem = new LogTaskItem();
            logTaskItem.setChecker_id(checker_id);
            logTaskItem.setChecker_name(checkerName);
            logTaskItem.setWorkId(item.getTE006());
            logTaskItem.setWorkType(item.getTE001());
            logTaskItem.setWorkNum(item.getTE007());
            SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date time=new Date();
            String times=timeFormat.format(time);
            logTaskItem.setCheckType(1);
            logTaskItem.setDate(times);
            logTaskItem.setProName(item.getTE018());
            logTaskItem.setUser_id(item.getTE004());
            //logTaskItem.setWorkSection(workSectionDao.findWorkSpaceName(item.getWork_section()));
//            logTaskItem.setWorkSection(item.getWork_section_name());
            logTaskItem.setWorkSection(spaceName);
            logTaskItem.setUser_name(item.getUser_name());
            logTaskDao.insertTask(logTaskItem);
            //上面是插入日志
            //求出该工段的最大审核级别
            int workIdentify = taskDao.findWorkSpaceIdentify(spaceName);
            if (item.getTE014() + 1 == workIdentify) {
                taskDao.updateState(6, primaryId);
               // sfcteDao.submitIntoSFCTETable(item);
            } else if(item.getTE014()==6||item.getTE014()==-1){
              return 0;
            } else {
                taskDao.updateState(item.getTE014() + 1, primaryId);
            }
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }












    public int checkerQueryPagesByProName(String user_id,String proName){
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem Titem: taskItemByWorkSpace) {
                if(Titem.getTE018().equals(proName)){
                    length++;
                }
            }
        }
        System.out.println(length);
        return length;
    }

    @Override
    public List<CompleteTable> checkerQueryDataByProName(String user_id, int page, String name) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        List<CompleteTable> completeTables =new ArrayList<>();
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem taskItem: taskItemByWorkSpace) {
                if(item.getCheck_identify()-taskItem.getTE014()>1){
                    continue;
                }else if(taskItem.getTE018().equals(name)){
                    CompleteTable completeTable =new CompleteTable();
                    completeTable.setUser_name(taskItem.getUser_name());
                    completeTable.setUser_id(taskItem.getTE004());
                    completeTable.setWorkType(taskItem.getTE001());
                    completeTable.setWorkId(taskItem.getTE002());
                    completeTable.setWorkNum(taskItem.getTE003());
                    completeTable.setReportType(taskItem.getTE006());
                    completeTable.setReportId(taskItem.getTE007());
                    completeTable.setMacName(taskItem.getMac_name());
                    completeTable.setMacId(taskItem.getTE005());
                    completeTable.setProName(taskItem.getTE018());
                    completeTable.setProSize(taskItem.getTE019());
                    completeTable.setWorkTec(taskItem.getWork_tec_name());
                    completeTable.setFailNum(taskItem.getTE010());
                    completeTable.setTransferNum(taskItem.getTE011());
                    completeTable.setCalType(taskItem.getTE030());
                    completeTable.setDate(taskItem.getDate());
                    completeTable.setProId(taskItem.getTE017());
                    completeTable.setMac_hour(taskItem.getMac_hour());
                    completeTable.setPrimaryId(taskItem.getPrimaryId());
                    completeTable.setWorkSection(taskItem.getWork_section());
                    completeTable.setWorkSectionName(taskItem.getWork_section_name());
                    completeTable.setWorkTecId(taskItem.getTE009());
                    completeTable.setInfo(taskItem.getTE015());
                    completeTable.setBack_info(taskItem.getBack_info());
                    completeTable.setWorkTime(taskItem.getWork_time());
                    if((item.getCheck_identify()-taskItem.getTE014())==1){
                        completeTable.setState(0);
                    }else {
                        completeTable.setState(1);
                    }
                    completeTable.setWork_hour(taskItem.getWork_hour());
                    completeTable.setWorkProcedure(taskItem.getTE008());
                    completeTable.setUser_local_name(taskItem.getUser_local_name());
                    completeTables.add(completeTable);
                }else{}
            }
        }
        List<CompleteTable> completeTables2 =new ArrayList<>();
        Collections.sort(completeTables);
        for(int i = (page-1)*10;i<page*10;i++){
            if(i<completeTables.size()){
                completeTables.get(i).setId(i+1);
                completeTables2.add(completeTables.get(i));
            }
        }
        return completeTables2;
    }

    @Override
    public List<CompleteTable> checkerQueryDataByDate(String user_id, int page, String date) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        List<CompleteTable> completeTables =new ArrayList<>();
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem taskItem: taskItemByWorkSpace) {
                if(item.getCheck_identify()-taskItem.getTE014()>1){
                    continue;
                }else if(taskItem.getDate().equals(date)){
                    CompleteTable completeTable =new CompleteTable();
                    completeTable.setUser_name(taskItem.getUser_name());
                    completeTable.setUser_id(taskItem.getTE004());
                    completeTable.setWorkType(taskItem.getTE001());
                    completeTable.setWorkId(taskItem.getTE002());
                    completeTable.setWorkNum(taskItem.getTE003());
                    completeTable.setReportType(taskItem.getTE006());
                    completeTable.setReportId(taskItem.getTE007());
                    completeTable.setMacName(taskItem.getMac_name());
                    completeTable.setMacId(taskItem.getTE005());
                    completeTable.setProName(taskItem.getTE018());
                    completeTable.setProSize(taskItem.getTE019());
                    completeTable.setWorkTec(taskItem.getWork_tec_name());
                    completeTable.setFailNum(taskItem.getTE010());
                    completeTable.setTransferNum(taskItem.getTE011());
                    completeTable.setCalType(taskItem.getTE030());
                    completeTable.setDate(taskItem.getDate());
                    completeTable.setProId(taskItem.getTE017());
                    completeTable.setMac_hour(taskItem.getMac_hour());
                    completeTable.setWorkSection(taskItem.getWork_section());
                    completeTable.setWorkSectionName(taskItem.getWork_section_name());
                    completeTable.setWorkTecId(taskItem.getTE009());
                    completeTable.setPrimaryId(taskItem.getPrimaryId());
                    if((item.getCheck_identify()-taskItem.getTE014())==1){
                        completeTable.setState(0);
                    }else {
                        completeTable.setState(1);
                    }
                    completeTable.setWork_hour(taskItem.getWork_hour());
                    completeTable.setWorkProcedure(taskItem.getTE008());
                    completeTable.setUser_local_name(taskItem.getUser_local_name());
                    completeTable.setInfo(taskItem.getTE015());
                    completeTable.setBack_info(taskItem.getBack_info());
                    completeTable.setWorkTime(taskItem.getWork_time());
                    completeTables.add(completeTable);
                }else{}
            }
        }
        List<CompleteTable> completeTables2 =new ArrayList<>();
        Collections.sort(completeTables);
        for(int i = (page-1)*10;i<page*10;i++){
            if(i<completeTables.size()){
                completeTables.get(i).setId(i+1);
                completeTables2.add(completeTables.get(i));
            }
        }
        return completeTables2;
    }

    @Override
    public int checkerQueryPagesByDate(String user_id, String date) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem Titem: taskItemByWorkSpace) {
                if(Titem.getDate().equals(date)){
                    length++;
                }
            }
        }
        System.out.println(length);
        return length;
    }

    @Override
    public int checkerQueryPagesByProNameAndDate(String user_id, String name, String date) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem Titem: taskItemByWorkSpace) {
                if(Titem.getDate().equals(date)&&Titem.getTE018().equals(name)){
                    length++;
                }
            }
        }
        System.out.println(length);
        return length;
    }

    @Override
    public List<CompleteTable> checkerQueryDataByProNameAndDate(String user_id, int page, String name, String date) {
        List<CheckerItem> checkerItems = taskDao.findCheckItemByUserId(user_id);
        List<CompleteTable> completeTables =new ArrayList<>();
        int length=0;
        for (CheckerItem item: checkerItems) {
            String workSpace =item.getWork_space();
            List<TaskItem> taskItemByWorkSpace = taskDao.findTaskItemByWorkSpace(workSpace);
            for (TaskItem taskItem: taskItemByWorkSpace) {
                if(item.getCheck_identify()-taskItem.getTE014()>1){
                    continue;
                }else if(taskItem.getDate().equals(date)&&taskItem.getTE018().equals(name)){
                    CompleteTable completeTable =new CompleteTable();
                    completeTable.setUser_name(taskItem.getUser_name());
                    completeTable.setUser_id(taskItem.getTE004());
                    completeTable.setWorkType(taskItem.getTE001());
                    completeTable.setWorkId(taskItem.getTE002());
                    completeTable.setWorkNum(taskItem.getTE003());
                    completeTable.setReportType(taskItem.getTE006());
                    completeTable.setReportId(taskItem.getTE007());
                    completeTable.setMacName(taskItem.getMac_name());
                    completeTable.setMacId(taskItem.getTE005());
                    completeTable.setProName(taskItem.getTE018());
                    completeTable.setProSize(taskItem.getTE019());
                    completeTable.setWorkTec(taskItem.getWork_tec_name());
                    completeTable.setFailNum(taskItem.getTE010());
                    completeTable.setTransferNum(taskItem.getTE011());
                    completeTable.setCalType(taskItem.getTE030());
                    completeTable.setDate(taskItem.getDate());
                    completeTable.setProId(taskItem.getTE017());
                    completeTable.setMac_hour(taskItem.getMac_hour());
                    completeTable.setWorkSection(taskItem.getWork_section());
                    completeTable.setWorkSectionName(taskItem.getWork_section_name());
                    completeTable.setWorkTecId(taskItem.getTE009());
                    if((item.getCheck_identify()-taskItem.getTE014())==1){
                        completeTable.setState(0);
                    }else {
                        completeTable.setState(1);
                    }
                    completeTable.setWork_hour(taskItem.getWork_hour());
                    completeTable.setWorkProcedure(taskItem.getTE008());
                    completeTable.setPrimaryId(taskItem.getPrimaryId());
                    completeTable.setUser_local_name(taskItem.getUser_local_name());
                    completeTable.setInfo(taskItem.getTE015());
                    completeTable.setBack_info(taskItem.getBack_info());
                    completeTable.setWorkTime(taskItem.getWork_time());
                    completeTables.add(completeTable);
                }else{}
            }
        }
        List<CompleteTable> completeTables2 =new ArrayList<>();
        Collections.sort(completeTables);
        for(int i = (page-1)*10;i<page*10;i++){
            if(i<completeTables.size()){
                completeTables.get(i).setId(i+1);
                completeTables2.add(completeTables.get(i));
            }
        }
        return completeTables2;
    }

    @Override
    public int findPagesByTwoDate(String user_id,String date1,String date2) {
        return  taskDao.findpagesByTwoDate(user_id,date1,date2);

    }

    @Override
    public int findPagesByProNameAndTwoDate(String user_id, String name, String date1,String date2) {
        return taskDao.findPagesByProNameAndTwoDate(user_id,name,date1,date2);

    }

    @Override
    public List<CompleteTable> findDataByTwoDate(String user_id,int page, String date1,String date2) {
        List<TaskItem> list= taskDao.findDateByTwoDate(user_id,(page-1)*10,date1,date2);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);
            CompleteTable completeTable =new CompleteTable();
            completeTable.setId((page-1)*10+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }

        return completeTables;
    }

    @Override
    public CompleteTable queryDataByPrimaryId(String primaryId) {

        TaskItem taskItem =taskDao.queryDataByPrimaryId(primaryId);
        if(taskItem==null)return null;
        CompleteTable completeTable = new CompleteTable();
        completeTable.setUser_name(taskItem.getUser_name());
        completeTable.setUser_id(taskItem.getTE004());
        completeTable.setWorkType(taskItem.getTE001());
        completeTable.setWorkId(taskItem.getTE002());
        completeTable.setWorkNum(taskItem.getTE003());
        completeTable.setReportType(taskItem.getTE006());
        completeTable.setReportId(taskItem.getTE007());
        completeTable.setMacName(taskItem.getMac_name());
        completeTable.setMacId(taskItem.getTE005());
        completeTable.setProName(taskItem.getTE018());
        completeTable.setProSize(taskItem.getTE019());
        completeTable.setWorkTec(taskItem.getWork_tec_name());
        completeTable.setFailNum(taskItem.getTE010());
        completeTable.setTransferNum(taskItem.getTE011());
        completeTable.setCalType(taskItem.getTE030());
        completeTable.setDate(taskItem.getDate());
        completeTable.setState(taskItem.getTE014());
        completeTable.setWork_hour(taskItem.getWork_hour());
        completeTable.setWorkProcedure(taskItem.getTE008());
        completeTable.setProId(taskItem.getTE017());
        completeTable.setMac_hour(taskItem.getMac_hour());
        completeTable.setPrimaryId(taskItem.getPrimaryId());
        completeTable.setWorkSection(taskItem.getWork_section());
        completeTable.setWorkSectionName(taskItem.getWork_section_name());
        completeTable.setWorkTecId(taskItem.getTE009());
        completeTable.setUser_local_name(taskItem.getUser_local_name());
        completeTable.setInfo(taskItem.getTE015());
        completeTable.setBack_info(taskItem.getBack_info());
        completeTable.setWorkTime(taskItem.getWork_time());
        return completeTable;
    }



    @Override
    public List<CompleteTable> queryDataByProNameAndDate(String id, int page, String name, String date1,String date2) {
        List<TaskItem> list= taskDao.findDataByProNameAndDate(id,(page-1)*10,name,date1,date2);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);
            CompleteTable completeTable =new CompleteTable();
            completeTable.setId((page-1)*10+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }
        return completeTables;
    }

    @Override
    public List<CompleteTable> queryDataByPublicPick(PublicUserTaskPick publicUserTaskPick) {
        String user_name=publicUserTaskPick.getUserName();
        String proName=publicUserTaskPick.getProName();
        String date1="";
        String date2="";
        if(publicUserTaskPick.getDate()!=null)
        {
            date1=publicUserTaskPick.getDate()[0];
            date2=publicUserTaskPick.getDate()[1];
        }
        String workTec = publicUserTaskPick.getWorkTec();
        int page=(publicUserTaskPick.getPageNum()-1)*10;
        List<TaskItem> list= taskDao.queryDataByPublicPick(user_name,proName,date1,date2,workTec,page);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);
            CompleteTable completeTable =new CompleteTable();
            completeTable.setId(page+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }
        return completeTables;
    }

    @Override
    public int queryPagesByPublicPick(PublicUserTaskPick publicUserTaskPick) {
        String user_name=publicUserTaskPick.getUserName();
        String proName=publicUserTaskPick.getProName();
        String date1="";
        String date2="";
        if(publicUserTaskPick.getDate()!=null)
        {
            date1=publicUserTaskPick.getDate()[0];
            date2=publicUserTaskPick.getDate()[1];
        }
        String workTec = publicUserTaskPick.getWorkTec();
        return taskDao.queryPagesByPublicPick(user_name,proName,date1,date2,workTec);
    }

    @Override
    public int deleteTask(String primaryId) {
//      String date1= PrimaryGenerater.getCreatDate();
      return taskDao.deleteTaskByWorkIdAndBeTweenDate(primaryId);
    }



    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int managerNotPass(String primaryId,String backInfo) {

            TaskItem item = taskDao.queryDataByPrimaryId(primaryId);
//        User user = userDao.findById(item.getTE004());
//            String work_sectionId = item.getWork_section();
        String spaceName = item.getUser_local_name();
            //下面是插入日志
            LogTaskItem logTaskItem = new LogTaskItem();
            logTaskItem.setChecker_id("");
            logTaskItem.setChecker_name("管理员");
        logTaskItem.setWorkId(item.getTE006());
        logTaskItem.setWorkType(item.getTE001());
        logTaskItem.setWorkNum(item.getTE007());
            SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date time=new Date();
            String times=timeFormat.format(time);
            logTaskItem.setCheckType(0);
            logTaskItem.setDate(times);
            logTaskItem.setProName(item.getTE018());
            logTaskItem.setUser_id(item.getTE004());
            //logTaskItem.setWorkSection(workSectionDao.findWorkSpaceName(item.getWork_section()));
            logTaskItem.setWorkSection(item.getWork_section_name());
            logTaskItem.setUser_name(item.getUser_name());
            logTaskDao.insertTask(logTaskItem);
            //下面是插入日志
            if (item.getTE014()  == 6) {
                taskDao.setBackInfo(primaryId,backInfo);
                taskDao.updateState(-1, primaryId);
            }
            return 1;
    }


    //日志文件的workId是工单单别 workNum 是工单单号
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRES_NEW)
    public int managerPass(String primaryId) {
            TaskItem item = taskDao.queryDataByPrimaryId(primaryId);
        if (item.getTE014()  == 6) {
              /*
            以下是测试的生成报工单单号和序号的操作
             */
            String date = item.getDate().replace("-", "");
            List<TaskItem> toDaySize=sfcteDao.findTodayTaskItemSize(date,item.getWork_section(),item.getTE001());
            int AlltodaySize = sfcteDao.findAllToday(date);
            String workId="";
            if(toDaySize.size()==0||toDaySize==null) {
                if(AlltodaySize==0){
//                workId = PrimaryGenerater.getId(table.getDate(),0);
                    workId=date+"001";
                }else {
                    String maxWorkIdToday= sfcteDao.findTodayMaxWorkId(date).substring(8);
                    String t = Integer.parseInt(maxWorkIdToday)+1+"";
                    int tlength=t.length();
                    for(int i=tlength;i<3;i++){
                        t="0"+t;
                    }
                    workId=date+t;
                }
            }else {
                workId =toDaySize.get(0).getTE002();
            }

            //序号
            int XuhaoSize= sfcteDao.findToDayXuhaoByWorkId(workId);
            String Xuhao;
            if(XuhaoSize==0){
                Xuhao="1";
            }else {
                String XuHaoId=sfcteDao.findToDayMaxXuhaoByWorkId(workId);
                Xuhao = Integer.parseInt(XuHaoId)+1+"";
            }
            int m=Xuhao.length();
            for(int i=m;i<4;i++){
                Xuhao="0"+Xuhao;
            }
            /*

             */

            item.setTE002(workId);
            item.setTE003(Xuhao);
            if(sfcteDao.submitIntoSFCTETable(item)!=1){
                taskDao.updateItem("","",primaryId);
                return 0;
            };
            taskDao.updateState(7, primaryId);
            taskDao.updateItem(workId,Xuhao,primaryId);
        }
            //下面是插入日志
//        User user = userDao.findById(item.getTE004());
//            String work_sectionId = item.getWork_section();
        String spaceName = item.getUser_local_name();
            //下面是插入日志
            LogTaskItem logTaskItem = new LogTaskItem();
            logTaskItem.setChecker_id("");
            logTaskItem.setChecker_name("管理员");
        logTaskItem.setWorkId(item.getTE006());
        logTaskItem.setWorkType(item.getTE001());
        logTaskItem.setWorkNum(item.getTE007());
            SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date time=new Date();
            String times=timeFormat.format(time);
            logTaskItem.setCheckType(1);
            logTaskItem.setDate(times);
            logTaskItem.setProName(item.getTE018());
            logTaskItem.setUser_id(item.getTE004());
            //logTaskItem.setWorkSection(workSectionDao.findWorkSpaceName(item.getWork_section()));
//            logTaskItem.setWorkSection(item.getWork_section_name());
        logTaskItem.setWorkSection(spaceName);
            logTaskItem.setUser_name(item.getUser_name());
            logTaskDao.insertTask(logTaskItem);

            return 1;
        }

    @Override
    public int deleteOwnTaskByMyself(String primaryId, String user_id, String password) {
        User user= userDao.findById(user_id);
        if(user==null||!user.getPassword().equals(password))
            return 0;

        return taskDao.deleteOwnTaskByMyself(primaryId,user_id);
    }




    @Override
    public int queryPagesByUserTaskPick(UserTaskPick userTaskPick) {
        String user_id=userTaskPick.getUser_id();
        String proName=userTaskPick.getProName();
        String date1="";
        String date2="";
        if(userTaskPick.getDate()!=null)
        {
            date1=userTaskPick.getDate()[0];
            date2=userTaskPick.getDate()[1];
        }
        return taskDao.queryPagesByUserTaskPick(user_id,date1,date2,proName);
    }

    @Override
    public List<CompleteTable> queryDataByUserTaskPick(UserTaskPick userTaskPick) {
        String user_id=userTaskPick.getUser_id();
        String proName=userTaskPick.getProName();
        String date1="";
        String date2="";
        if(userTaskPick.getDate()!=null)
        {
            date1=userTaskPick.getDate()[0];
            date2=userTaskPick.getDate()[1];
        }
        int page = (userTaskPick.getPageNum()-1)*10;
        List<TaskItem> list= taskDao.queryDataByUserTaskPick(user_id,date1,date2,proName,page);
        List<CompleteTable> completeTables =new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            TaskItem taskItem =list.get(i);
            CompleteTable completeTable =new CompleteTable();
            completeTable.setId(page+i+1);
            completeTable.setUser_name(taskItem.getUser_name());
            completeTable.setUser_id(taskItem.getTE004());
            completeTable.setWorkType(taskItem.getTE001());
            completeTable.setWorkId(taskItem.getTE002());
            completeTable.setWorkNum(taskItem.getTE003());
            completeTable.setReportType(taskItem.getTE006());
            completeTable.setReportId(taskItem.getTE007());
            completeTable.setMacName(taskItem.getMac_name());
            completeTable.setMacId(taskItem.getTE005());
            completeTable.setProName(taskItem.getTE018());
            completeTable.setProSize(taskItem.getTE019());
            completeTable.setWorkTec(taskItem.getWork_tec_name());
            completeTable.setFailNum(taskItem.getTE010());
            completeTable.setTransferNum(taskItem.getTE011());
            completeTable.setCalType(taskItem.getTE030());
            completeTable.setDate(taskItem.getDate());
            completeTable.setState(taskItem.getTE014());
            completeTable.setWork_hour(taskItem.getWork_hour());
            completeTable.setWorkProcedure(taskItem.getTE008());
            completeTable.setProId(taskItem.getTE017());
            completeTable.setMac_hour(taskItem.getMac_hour());
            completeTable.setPrimaryId(taskItem.getPrimaryId());
            completeTable.setWorkSection(taskItem.getWork_section());
            completeTable.setWorkSectionName(taskItem.getWork_section_name());
            completeTable.setWorkTecId(taskItem.getTE009());
            completeTable.setUser_local_name(taskItem.getUser_local_name());
            completeTable.setInfo(taskItem.getTE015());
            completeTable.setBack_info(taskItem.getBack_info());
            completeTable.setWorkTime(taskItem.getWork_time());
            completeTables.add(completeTable);
        }
        return completeTables;
    }

    @Override
    public List<String> managerQueryAllWorkSpace() {
        return workSectionDao.managerQueryAllWorkSpace();
    }


}
